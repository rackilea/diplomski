import java.util.*;
import java.io.*;
import java.net.*;
class TCPServer{
    public static void main(String args[]) throws Exception{
    ServerSocket server = new ServerSocket(4888);
    while(true){
    Socket client = server.accept();
    System.out.println(client);
    DataOutputStream out = new DataOutputStream(client.getOutputStream());
    File path = new File("C://Users/Brian/Desktop");
    String[] files = path.list();
    String send = "";
    for(String file:files){
        send = send + file + "\n";
    }
    send = send + "END\n"; // ADD SOMETHING LIKE THIS ------------------------------>
    out.writeBytes(send);
    BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream    ()));
    String search_file = in.readLine();
    String searching = "";
    for(String file:files){
        if (file.equals(search_file)){
        searching = search_file;
        }
    }
if(searching.equals("")){
        out.writeBytes("Requested file does not exist");
        client.close();
    }
    Scanner file = new Scanner(new FileReader(searching));
    while(file.hasNextLine()){
        out.writeBytes(file.nextLine() + "\n"); // ADD A NEWLINE HERE ------------------>
    }
    client.close();
    }
    }
}