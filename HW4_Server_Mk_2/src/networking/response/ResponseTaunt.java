package networking.response;

import utility.GamePacket;
import utility.Log;
import metadata.Constants;
import model.Player;

public class ResponseTaunt extends GameResponse {

    Player player;
    private int playerId;
    
    public ResponseTaunt()
    {
        responseCode = Constants.SMSG_TAUNT;
    }
    @Override
    public byte[] constructResponseInBytes() {
        GamePacket packet = new GamePacket(responseCode);
        packet.addInt32(playerId);
        Log.printf("Player %d taunted", player.getID());

        return packet.getBytes();
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
