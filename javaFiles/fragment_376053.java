/*
 * ENCRYPTION USING Jpair SCHEME
 * DONE ACCORDING IBE SCHEME
 */

package ibe;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Random;
import uk.ac.ic.doc.jpair.api.*;
import uk.ac.ic.doc.jpair.ibe.*;
import uk.ac.ic.doc.jpair.ibe.key.*;
import uk.ac.ic.doc.jpair.pairing.*;

public class Main {
    public static void main(String[] args) {

        //  GENERATE PAIRING "e"
        Pairing e = Predefined.nssTate();

        // SETUP
        java.security.KeyPair masterKey=BFCipher.setup( e ,new Random());


        //  EXTRACT
        java.security.KeyPair userKey=BFCipher.extract( masterKey,"abcd",new Random());
        //"abcd" can be replaced with an ID for user
        PublicKey uPub = userKey.getPublic();       //to use in encrypt()
        PrivateKey uPri = userKey.getPrivate();     //to use in decrypt()

        //  ENCRYPT
        byte msgenc[]= new byte[50];
        String s = "test message";
        msgenc = s.getBytes();
        System.out.println("MESSAGE BEFORE ENCRYPTION : " + s);

        BFCtext msgCipher = BFCipher.encrypt((BFUserPublicKey) uPub,msgenc, new Random()) ;

        //  DECRYPT
        byte msgdec[]=new byte[50];
        msgdec=BFCipher.decrypt(msgCipher, (BFUserPrivateKey) uPri) ;
        System.out.println("AFTER DECRYPTION : " );
        // Printing message
        for(int j = 0; j < msgdec.length; j++) {
            System.out.print((char)msgdec[j]);
        }

    }



}