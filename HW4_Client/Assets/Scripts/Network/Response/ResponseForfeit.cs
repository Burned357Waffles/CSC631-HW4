using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ResponseForfeitEventArgs : ExtendedEventArgs
{
	public int user_id { get; set; } // The user_id of whom who sent the request

	public ResponseForfeitEventArgs()
	{
		event_id = Constants.SMSG_LEAVE;
	}
}

public class ResponseForfeit : NetworkResponse
{
	private int user_id;

	public ResponseForfeit()
	{
	}

	public override void parse()
	{
		user_id = DataReader.ReadInt(dataStream);
	}

	public override ExtendedEventArgs process()
	{
		ResponseForfeitEventArgs args = new ResponseForfeitEventArgs
		{
			user_id = user_id
		};

		return args;
	}
}
