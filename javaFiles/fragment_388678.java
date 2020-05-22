import org.json.JSONArray;

public class orgJson1Main {
    private static final String sample = "[{\"HostName\":\"taskmanager1\",\"Rack\":\"/default-rack\",\"State\":\"RUNNING\",\"NodeId\":\"taskmanager1:45454\",\"NodeHTTPAddress\":\"taskmanager1:8042\",\"LastHealthUpdate\":1519568501615,\"HealthReport\":\"\",\"NodeManagerVersion\":\"2.8.3\",\"NumContainers\":0,\"UsedMemoryMB\":0,\"AvailableMemoryMB\":1024},{\"HostName\":\"datanode2\",\"Rack\":\"/default-rack\",\"State\":\"RUNNING\",\"NodeId\":\"datanode2:45454\",\"NodeHTTPAddress\":\"datanode2:8042\",\"LastHealthUpdate\":1519260876106,\"HealthReport\":\"\",\"NodeManagerVersion\":\"2.8.3\",\"NumContainers\":0,\"UsedMemoryMB\":0,\"AvailableMemoryMB\":1024},{\"HostName\":\"taskmanager3\",\"Rack\":\"/default-rack\",\"State\":\"RUNNING\",\"NodeId\":\"taskmanager3:45454\",\"NodeHTTPAddress\":\"taskmanager3:8042\",\"LastHealthUpdate\":1519568502251,\"HealthReport\":\"\",\"NodeManagerVersion\":\"2.8.3\",\"NumContainers\":0,\"UsedMemoryMB\":0,\"AvailableMemoryMB\":1024},{\"HostName\":\"datanode3\",\"Rack\":\"/default-rack\",\"State\":\"RUNNING\",\"NodeId\":\"datanode3:45454\",\"NodeHTTPAddress\":\"datanode3:8042\",\"LastHealthUpdate\":1519260871527,\"HealthReport\":\"\",\"NodeManagerVersion\":\"2.8.3\",\"NumContainers\":0,\"UsedMemoryMB\":0,\"AvailableMemoryMB\":1024},{\"HostName\":\"taskmanager2\",\"Rack\":\"/default-rack\",\"State\":\"RUNNING\",\"NodeId\":\"taskmanager2:45454\",\"NodeHTTPAddress\":\"taskmanager2:8042\",\"LastHealthUpdate\":1519568502259,\"HealthReport\":\"\",\"NodeManagerVersion\":\"2.8.3\",\"NumContainers\":0,\"UsedMemoryMB\":0,\"AvailableMemoryMB\":1024},{\"HostName\":\"datanode1\",\"Rack\":\"/default-rack\",\"State\":\"RUNNING\",\"NodeId\":\"datanode1:45454\",\"NodeHTTPAddress\":\"datanode1:8042\",\"LastHealthUpdate\":1519260875647,\"HealthReport\":\"\",\"NodeManagerVersion\":\"2.8.3\",\"NumContainers\":0,\"UsedMemoryMB\":0,\"AvailableMemoryMB\":1024}]";

    public static void main(String[] args) {
        JSONArray array = new JSONArray(sample);
        for(int i=0; i < array.length(); i++){
            System.out.println(array.get(i));
        }
    }

}