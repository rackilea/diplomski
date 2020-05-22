package com.Queue;
import com.ibm.mqlight.api.ClientOptions;

import com.ibm.mqlight.api.Delivery;
import com.ibm.mqlight.api.DestinationAdapter;
import com.ibm.mqlight.api.NonBlockingClient;
import com.ibm.mqlight.api.NonBlockingClientAdapter;
import com.ibm.mqlight.api.StringDelivery;


public class SendReceive2 
{
    public static void main(String[] cmdline) 
    {
        ClientOptions clientOpts = ClientOptions.builder().setCredentials("ad", "jms123").build();



        NonBlockingClient.create("amqp://localhost", clientOpts, new NonBlockingClientAdapter<Void>()
        {

            public void onStarted(NonBlockingClient client, Void context) 
            {
                client.subscribe("JmsQueue",  new DestinationAdapter<Void>() 
                {
                    public void onMessage(NonBlockingClient client, Void context, Delivery delivery) 
                    {
                        if (delivery.getType() == Delivery.Type.STRING)
                            System.out.println(((StringDelivery)delivery).getData());
                    }
                }, null, null);
            }
        }, null);





        NonBlockingClient.create("amqp://localhost", clientOpts, new NonBlockingClientAdapter<Void>()
        {
            public void onStarted(NonBlockingClient client, Void context) 
            {
                client.send("JmsQueue", "Jms Queue is Formed!", null);
            }

        }, null);






    }//main


}//class