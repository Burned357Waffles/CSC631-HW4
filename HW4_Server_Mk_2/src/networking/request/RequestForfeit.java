package networking.request;

// Java Imports
import java.io.IOException;

// Other Imports
import model.Player;
import networking.response.ResponseForfeit;
import core.NetworkManager;

public class RequestForfeit extends GameRequest {
    // Responses
    private ResponseForfeit responseForfeit;

    public RequestForfeit() {
        responses.add(responseForfeit = new ResponseForfeit());
    }

    @Override
    public void parse() throws IOException {

    }

    @Override
    public void doBusiness() throws Exception {
        Player player = client.getPlayer();

        responseForfeit.setPlayer(player);

        NetworkManager.addResponseForAllOnlinePlayers(player.getID(), responseForfeit);
    }
}