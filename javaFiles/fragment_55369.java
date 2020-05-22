package com.test;

import java.io.IOException;
import java.net.Socket;

public class PortScan {
    public static void main(String[] args) {
        if (args.length > 0 ){
            System.out.println("Port active: " + available(args[0], args[1]));
        }
        else System.out.println("Usage: PortScan <ip> <port>");
    }

    public static boolean available(String ip, String port) {
        boolean status = false;
        Socket ss = null;
        try {
            ss = new Socket(ip, Integer.parseInt(port));
            status = true; //there is a listening port 
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ss != null) {
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return status;
    }
}