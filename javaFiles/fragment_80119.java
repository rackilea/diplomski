import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.RpcClient;

public class HelloClient {
    public static void main(String[] args) {
        try {
            String request = (args.length > 0) ? args[0] : "Rabbit";
            String hostName = (args.length > 1) ? args[1] : "localhost";
            int portNumber = (args.length > 2) ? Integer.parseInt(args[2]) : AMQP.PROTOCOL.PORT;

            ConnectionFactory cfconn = new ConnectionFactory(); 
            cfconn.setHost(hostName); 
            cfconn.setPort(portNumber);
            Connection conn = cfconn.newConnection();
            Channel ch = conn.createChannel();
            RpcClient service = new RpcClient(ch, "", "Hello");

            System.out.println(service.stringCall(request));
            conn.close();
        } catch (Exception e) {
            System.err.println("Main thread caught exception: " + e);
            e.printStackTrace();
            System.exit(1);
        }
    }
}