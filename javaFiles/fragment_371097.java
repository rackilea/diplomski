import io.iron.ironmq.Client;

import io.iron.ironmq.Cloud;
import io.iron.ironmq.Message;
import io.iron.ironmq.Queue;

public class IronMqTest5 {

    public static void main(String[] args) 
    {
        String projectId="54567889000c707";
        String token="3b3u7uwjwjj8726QZ9CO";
        String scheme="https";
        String host="mq-aws-us-east-1-2.iron.io";
        int port=443;
        try
        {
            Client c = new Client(projectId, token, new Cloud(scheme, host,port));
            //Client c = new Client(projectId, token, new Cloud("http", "localhost", 8080), apiVersion); //this is speified on the github doc but not working here
            Queue q = c.queue("ESIResponse");
            Message msg=q.get();
            System.out.println(msg.getBody());

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }


}