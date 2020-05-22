package javaapplication2;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import microsoft.aspnet.signalr.client.SignalRFuture;
import microsoft.aspnet.signalr.client.hubs.HubConnection;
import microsoft.aspnet.signalr.client.hubs.HubProxy;
import microsoft.aspnet.signalr.client.transport.ServerSentEventsTransport;
import microsoft.aspnet.signalr.client.hubs.SubscriptionHandler2;

public class JavaApplication2 {
   public static void main(String[] args) throws IOException, InterruptedException, ExecutionException, TimeoutException 
   {
        String ServerURI = "http://localhost:8080/signalr";
        HubConnection Connection = new HubConnection(ServerURI);
        HubProxy HubProxy = Connection.createHubProxy("MyHub");

        HubProxy.on("AddMessage", new SubscriptionHandler2<String, String>() {
          @Override
          public void run(String e1, String e2) {
             System.out.println(e1.toString()+  " -> " +e2.toString());   
          }
        }, String.class, String.class);

        SignalRFuture<Void> con  =Connection.start(new ServerSentEventsTransport(Connection.getLogger())); //Or LongPollingTransport

        con.get(); 

        Scanner inputReader = new Scanner(System.in);
        String line = inputReader.nextLine();
        while (!"exit".equals(line)) {
              HubProxy.invoke("send", "Console", line);
              line = inputReader.next();
         }

        inputReader.close();

        Connection.stop();
   }
}