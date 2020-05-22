import java.io.*;
import java.net.*;
import java.util.List;
import java.util.ArrayList;

public class FindUsers{
    InetAddress inetAddress;
    List<String> ipList = new ArrayList<String>();
    List<String> nameList = new ArrayList<String>();
    String ipAddress;
    String name;
    DatagramSocket  clientSocket;
    DatagramPacket receivePacket;
    int count=0;
    byte[] receiveData;
    long futureTime;
    Thread collect;
    boolean refresh = true;

    public FindUsers(){
        futureTime = System.currentTimeMillis()+1100;

        try{
            clientSocket = new DatagramSocket(9877);
        }
        catch(IOException e){
            e.printStackTrace();
            System.out.println(e.toString());
        }

        collect = new Thread(new Runnable(){
            public void run(){
                for(;;){
                    receiveData = new byte[15];
                    receivePacket = new DatagramPacket(receiveData, receiveData.length);
                    try{
                    clientSocket.receive(receivePacket);
                    inetAddress = receivePacket.getAddress();
                    ipAddress = inetAddress.getHostAddress();
                    }
                    catch(IOException e){
                        //e.printStackTrace();
                    }
                    if(!ipList.contains(ipAddress)){
                        name = new String( receivePacket.getData());
                        ipList.add(ipAddress);
                        nameList.add(name);
                        receiveData = null;
                    }
                    try{
                        Thread.sleep(10);
                    }
                    catch(InterruptedException e){
                        //System.out.println("\nInterrupted!");
                        return;
                    }
                }
            }
        });
        collect.start();

        while(System.currentTimeMillis()<=futureTime){
            //do nothing.
        }
        clientSocket.close();
        collect.interrupt();

        int size = nameList.size();
        if (size==0){
            System.out.println("No online servers.");
        }
        else{
            for(int i = 0; i< nameList.size();i++){
                System.out.println(nameList.get(i)+ ": "+ ipList.get(i));
            }
        }
    }

    public static void main(String[] args){
        FindUsers f = new FindUsers();
    }
}