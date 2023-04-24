package networking.response;

import utility.GamePacket;
import utility.Log;
import metadata.Constants;
import model.Player;

public class ResponseTaunt extends GameResponse {

    Player player;
    private int playerId;
    
    public ResponseTaunt(int playerId)
    {
        responseCode = Constants.SMSG_TAUNT;
        this.playerId = playerId;
    }
    @Override
    public byte[] constructResponseInBytes() {
        // TODO Auto-generated method stub
        GamePacket packet = new GamePacket(responseCode);
        packet.addInt32(playerId);
        Log.printf("Player %d taunted", player.getID());

        return packet.getBytes();
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
