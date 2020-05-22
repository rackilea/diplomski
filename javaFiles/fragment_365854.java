import java.util.ArrayList;
import java.util.List;

public class GetServers {
    public static void main(String[] args) {

        String text = "[instance_pids(server_name='Builds', java_pid=22293, screen_pid=22292, base_dir='/var/games/minecraft'),instance_pids(server_name='PropHunt', java_pid=7595, screen_pid=7594, base_dir='/var/games/minecraft'),instance_pids(server_name='Modded', java_pid=5820, screen_pid=5819, base_dir='/var/games/minecraft'),instance_pids(server_name='Spleeg', java_pid=10697, screen_pid=10696, base_dir='/var/games/minecraft'),instance_pids(server_name='Survival', java_pid=19297, screen_pid=19296, base_dir='/var/games/minecraft'),instance_pids(server_name='Hub', java_pid=20069, screen_pid=20068, base_dir='/var/games/minecraft'),instance_pids(server_name='Bungee', java_pid=20301, screen_pid=20300, base_dir='/var/games/minecraft')]";

        text = text.replace("instance_pids", "");
        text = text.replace("[", "");
        text = text.replace("]", "");

        String[] serverList = text.split("\\),\\(");

        List<String> serverNames = new ArrayList<String>();

        for (int i = 0; i < serverList.length; i++) {
            String serverLine = serverList[i];
            serverLine = serverLine.replace("(", "");
            serverLine = serverLine.replace(")", "");

            String[] serverLineParams = serverLine.split(",");

            for (int j = 0; j < serverLineParams.length; j++) {

                String serverLineParamVar = serverLineParams[j];

                if (serverLineParamVar.contains("server_name")) {
                    serverNames.add(serverLineParamVar.split("=")[1].replace(
                            "'", ""));
                }
            }
        }

        System.out.println("Server names are : " + serverNames);
    }
}