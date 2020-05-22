import java.util.HashMap;
import java.util.Map;

import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

public class Main {
    public static void main( String[] args ) throws Exception {
        String node = args[0];
        String port = args[1];
        String username = args[2];
        String password = args[3];

        JMXServiceURL url = new JMXServiceURL( "service:jmx:rmi:///jndi/rmi://" + node + ":" + port + "/jmxrmi" );
        String[] credentials = {username, password};

        Map<String, String[]> environment = new HashMap<>();
        environment.put( JMXConnector.CREDENTIALS, credentials );
        JMXConnector jmxConnector = JMXConnectorFactory.connect( url, environment );
        MBeanServerConnection mbsc = jmxConnector.getMBeanServerConnection();//Get metrics bean
        ObjectName oName = new ObjectName( "org.apache.cassandra.net:type=FailureDetector" );//create JMX object name
        int downNodes = (int) mbsc.getAttribute( oName, "DownEndpointCount" ); //get number of unavailable nodes

        System.out.println("Down node count: " + downNodes);
    }
}