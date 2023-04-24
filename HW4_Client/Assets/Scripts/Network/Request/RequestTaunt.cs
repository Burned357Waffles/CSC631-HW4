using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class RequestTaunt : NetworkRequest
{
    public RequestSetName()
    {
        request_id = Constants.CMSG_TAUNT;
    }

    public void send(string name)
    {
        packet = new GamePacket(request_id);
    }
}