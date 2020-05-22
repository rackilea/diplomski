package com.stackoverflow._19531411;

import java.net.InetAddress;


public class NetmaskToCIDR {


    public static int convertNetmaskToCIDR(InetAddress netmask){

        byte[] netmaskBytes = netmask.getAddress();
        int cidr = 0;
        boolean zero = false;
        for(byte b : netmaskBytes){
            int mask = 0x80;

            for(int i = 0; i < 8; i++){
                int result = b & mask;
                if(result == 0){
                    zero = true;
                }else if(zero){
                    throw new IllegalArgumentException("Invalid netmask.");
                } else {
                    cidr++;
                }
                mask >>>= 1;
            }
        }
        return cidr;
    }

    public static void main(String[] args) throws Exception {

        InetAddress netmask = InetAddress.getByName("255.255.128.0");

        System.out.println(convertNetmaskToCIDR(netmask));

    }
}