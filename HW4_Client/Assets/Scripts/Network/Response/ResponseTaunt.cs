using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ResponseTauntEventArgs : ExtendedEventArgs
{
    public int user_id { get; set; } // The user_id of whom who sent the request

    public ResponseTauntEventArgs()
    {
        event_id = Constants.SMSG_TAUNT;
    }
}

public class ResponseTaunt : NetworkResponse
{
    private int user_id;

    public ResponseTaunt()
    {
    }

    public override void parse()
    {
        user_id = DataReader.ReadInt(dataStream);
    }

    public override ExtendedEventArgs process()
    {
        ResponseTauntEventArgs args = new ResponseTauntEventArgs
        {
            user_id = user_id
        };

        return args;
    }
}