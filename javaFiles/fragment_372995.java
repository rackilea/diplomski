package com.pkg1;

import java.util.LinkedList;

public class Sample{


    public Sample(){
        LinkedList[]    mailbox = new LinkedList[10];
        for ( int i=0; i< 10; i++ ){ 
            mailbox[i] = new LinkedList<Message>();
            mailbox[i].add(new Message(i));
    }
    }
    private class Message 
    { 
        // instance variables 
        private int senderId;  

        private Intention iIntendToAssistAt; 

        public Message( int senderId ) 
        { 
            this.senderId = senderId;  

        } // end constructor 

        public void setIntentions( Intention intention ) 
        { 
            iIntendToAssistAt = intention; 
        } 



        public Intention getIntentions() 
        { 
            return iIntendToAssistAt; 
        } 


        public int getSenderId() 
        { 
            return senderId; 
        } 


    } // end Message class 

    private class Intention
    {
        // instance variables 

        private double distanceTo; 

        public Intention( double distance ) 
        { 
            distanceTo = distance; 
        } // end constructor 


        public double getDistancetoTarget() 
        { 
            return distanceTo;
        } 

    }
}