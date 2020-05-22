package com.cubepro.util;

import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Formatter;

import org.apache.log4j.Logger;
import org.smslib.helper.CommPortIdentifier;

import com.cubepro.general.CommonConstants;

import com.cubepro.util.SendMessage;

public class CommPortTester {
   private static final String _NO_DEVICE_FOUND = "  no device found";

   private final static Formatter _formatter = new Formatter(System.out);

   private static Logger log = Logger.getLogger(CommPortTester.class);

   static CommPortIdentifier portId;

   static Enumeration<CommPortIdentifier> portList;

   static int bauds[] = { 9600, 14400, 19200, 28800, 33600, 38400, 56000,
                          57600, 115200 };

   public static final String MAINCLASS = "org.smslib.Service";

   public CommPortTester() throws Exception {
      Class.forName(MAINCLASS);
   }

   /**
    * Wrapper around {@link CommPortIdentifier#getPortIdentifiers()} to be
    * avoid unchecked warnings.
    */
   private static Enumeration<CommPortIdentifier> getCleanPortIdentifiers() {
      return CommPortIdentifier.getPortIdentifiers();
   }

   public String testAndQualifyPort() throws Exception {
      String status = CommonConstants.MODEM_STATUS_ERROR;
      SendMessage sendMessage = new SendMessage();

      log.debug("\nSearching for devices...");
      portList = getCleanPortIdentifiers();

      while (portList.hasMoreElements()) {
         portId = portList.nextElement();
         if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
            _formatter.format("%nFound port: %-5s%n", portId.getName());
            try {
               if(portId.getName()
               boolean comPortSuccess = sendMessage.doIt(portId.getName());
               if(comPortSuccess == true){
                  return portId.getName();
               }
            } catch (final Exception e) {
               log.debug(" Modem error occured -",e);
            }
         }
      }
      log.debug("\nTest complete.");
      return status;
   }

   public static void main(String[]args){
      try{
      CommPortTester tester = new CommPortTester(); 
      tester.testAndQualifyPort();
      }catch(Exception e){
         e.printStackTrace();
      }
   }
}