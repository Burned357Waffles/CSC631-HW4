using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class RequestForfeit : NetworkRequest
{
	public RequestForfeit()
	{
		request_id = Constants.CMSG_FORFEIT;
	}

	public void send()
	{
		packet = new GamePacket(request_id);
	}
}
