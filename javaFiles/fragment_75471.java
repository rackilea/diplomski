package com.example.fizatanveerkhan.citycops;

import java.util.HashMap;

public class UserInformation {

    private String uphone;
    private String uphoto ;
    private String uname;
    private String address;

    private TrustedContact1 TrustedContact1;

    // use inner class on create class in another file
    class TrustedContact1{
       public TrustedContact1(){
       }
       private String contactname1;
       private String contactnumber1;
   }

    // getters and seeters

}