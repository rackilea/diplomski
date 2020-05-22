import java.util.*;
import java.lang.System;

import com.google.common.net.InetAddresses;

public class IPCheck{

  public static String[] extractLine(String line){
    String[] temp;
    temp = line.split("\\s+");

    return temp;
  }

  public static boolean hasNetMask(String line){
    boolean result = false;
    if(line.indexOf("/") != -1)
    result = true;

    return result;
  }

  public static boolean hasIPRange(String line){
    boolean result = false;
    if(line.indexOf("-") != -1)
    result = true;

    return result;
  }

  public static String extractNetMask(String line){
    String result = "";
    result = line.substring(line.indexOf("/"));

    return result;
  }

  public static String extractIPRange(String line){
    String result = "";
    result = line.substring(line.indexOf("-"));

    return result;
  }

  public static String chop(String line, String piece){
    String result = "";
    result = line.replace(piece, "");

    return result;
  }

  public static boolean validateIPRange(String ipRange){
    int tmpInt = 0;
    ipRange = chop(ipRange, "-");
    tmpInt = Integer.valueOf(ipRange);
    if(tmpInt > 255)
      return false;
    else
      return true;
  }

  public static void main(String args[]){
    String validIPAddress = "";
    String invalidIPAddress = "";
    String str = "10.1.1.1-300\n192.180.0.1-10/16\n192.168.0.1111";
    String[] addressList;
    String netMask = "";
    String ipRange = "";

    addressList = extractLine(str);
    for(int i=0; i<addressList.length; i++){

    if(hasNetMask(addressList[i]) == true){
      netMask = extractNetMask(addressList[i]);
      addressList[i] = chop(addressList[i], netMask);
    }

    if(hasIPRange(addressList[i]) == true){
      ipRange = extractIPRange(addressList[i]);
      addressList[i] = chop(addressList[i], ipRange);

       if(validateIPRange(ipRange) == false){
        /*if the IPRange is not valid, let's attach the ipRange
        to the current IP-Address to make it invalid*/
        addressList[i] = addressList[i].concat(ipRange);
        System.out.println( addressList[i]);
       }
    }

    if(InetAddresses.isInetAddress(addressList[i]) == true){
      validIPAddress = validIPAddress.concat(addressList[i] + ipRange + netMask);
    } else {
      invalidIPAddress = invalidIPAddress.concat(addressList[i] + ipRange + netMask);
    }
  }
 }
}