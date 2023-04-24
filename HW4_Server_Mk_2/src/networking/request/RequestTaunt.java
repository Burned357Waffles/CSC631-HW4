package networking.request;

import java.io.IOException;

import core.NetworkManager;
import model.Player;
import networking.response.ResponseTaunt;

public class RequestTaunt extends GameRequest {

    private Player player;
    private ResponseTaunt responseTaunt;

    public RequestTaunt()
    {
        responses.add(responseTaunt = new ResponseTaunt(player.getID()));
    }
    @Override
    public void parse() throws IOException {    

    }

    @Override
    public void doBusiness() throws Exception {
        player = client.getPlayer();

        NetworkManager.addResponseForAllOnlinePlayers(player.getID(), responseTaunt);
        
    }
    
}
