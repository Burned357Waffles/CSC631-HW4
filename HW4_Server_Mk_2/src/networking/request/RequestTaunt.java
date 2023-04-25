package networking.request;

import java.io.IOException;

import core.NetworkManager;
import model.Player;
import networking.response.ResponseTaunt;
import utility.Log;

public class RequestTaunt extends GameRequest {

    private Player player;
    private ResponseTaunt responseTaunt;

    public RequestTaunt()
    {
        responses.add(responseTaunt = new ResponseTaunt());
    }
    
    @Override
    public void parse() throws IOException {    

    }

    @Override
    public void doBusiness() throws Exception {
        player = client.getPlayer();


        responseTaunt.setPlayer(player);

        NetworkManager.addResponseForAllOnlinePlayers(player.getID(), responseTaunt);
        
    }
    
}
