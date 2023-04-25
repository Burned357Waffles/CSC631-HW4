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
    private int playerId;

    public ResponseForfeit() {
        responseCode = Constants.SMSG_FORFEIT;
    }

    @Override
    public byte[] constructResponseInBytes() {
        GamePacket packet = new GamePacket(responseCode);
        packet.addInt32(playerId);
        Log.printf("Player %d forfeited", player.getID());

        return packet.getBytes();
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}