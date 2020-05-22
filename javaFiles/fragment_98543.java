import java.io.*;
import java.net.*;


public class Server {

    public static void run() {
        try
        {
            ServerSocket ecoute;
            ecoute = new ServerSocket(1111);
            Socket service = null;
            System.out.println("serveur en attente d'un client!");
            while(true)
            {
                service = ecoute.accept();
                System.out.println("client connécté!");
//              ##call a new thread
                WorkerThread wt = new WorkerThread(service);
                wt.start();
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        run();
    }
}


class WorkerThread extends Thread {
    Socket service;
    WorkerThread(Socket service) {
        this.service = service;
    }

    public void run() {
    boolean flag=true;    //you can change this flag's condition, to test if the client disconects
    try
    {
        while (flag){
            DataInputStream is = new DataInputStream(service.getInputStream());
            System.out.println("client dit: " + is.readUTF().toUpperCase());
        }
        service.close();
    }
    catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}