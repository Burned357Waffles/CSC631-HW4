package networking.response;

// Other Imports
import core.GameServer;
import metadata.Constants;
import model.Player;
import utility.GamePacket;
import utility.Log;
import java.util.List;

public class ResponseForfeit extends GameResponse {
    private Player player;

    public ResponseForfeit() {
        responseCode = Constants.SMSG_FORFEIT;
    }

    @Override
    public byte[] constructResponseInBytes() {
        GamePacket packet = new GamePacket(responseCode);
        packet.addInt32(player.getID());

        GameServer gs = GameServer.getInstance();
        List<Player> activePlayers = gs.getActivePlayers();

        for(Player p : activePlayers) {
            if(p.getID() == player.getID()) {
                gs.removeActivePlayer(p.getID());
                Log.printf("Player with id %d has been removed", player.getID());
            }
        }

        Log.printf("Player with id %d has forfeited.", player.getID());
        player.setReadyStatusOn(false);
        return packet.getBytes();
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}