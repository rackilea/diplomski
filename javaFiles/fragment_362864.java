import javax.crypto.SecretKey;
import javax.crypto.KeyGenerator;
import javax.crypto.Cipher;
import javax.crypto.SealedObject;
import java.io.Serializable;

import java.io.ByteArrayOutputStream;
import javax.crypto.CipherOutputStream;
import java.io.ObjectOutputStream;

import java.io.ByteArrayInputStream;
import javax.crypto.CipherInputStream;
import java.io.ObjectInputStream;

import java.util.Base64;

public class MyClass {
    public static void main(String args[]) {
        OtherClass myObject = new OtherClass();
        myObject.print();
    }
}

// you can add other public classes to this editor in any order
class OtherClass
{
public void print() {


 try {
       String userCodes = "Test123";
        // generate a secret key using the DES algorithm
        SecretKey key = KeyGenerator.getInstance("DES").generateKey();
        Cipher ecipher = Cipher.getInstance("DES");
        // initialize the ciphers with the given key
        ecipher.init(Cipher.ENCRYPT_MODE, key);
        // create a sealed object
        SealedObject sealed = new SealedObject((Serializable) userCodes, ecipher);

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    CipherOutputStream cipherOutputStream = new CipherOutputStream(
            outputStream, ecipher);

    ObjectOutputStream oos = new ObjectOutputStream(cipherOutputStream);
    oos.writeObject( sealed );
    cipherOutputStream.close();

    byte[] values = outputStream.toByteArray();

    String base64encoded = Base64.getEncoder().encodeToString(values);
    System.out.println(base64encoded);

    // decrypt
    Cipher fcipher = Cipher.getInstance("DES");
    fcipher.init(Cipher.DECRYPT_MODE, key);

    ByteArrayInputStream istream = new ByteArrayInputStream(Base64.getDecoder().decode(base64encoded));
    CipherInputStream cipherInputStream = new CipherInputStream(istream, fcipher);
    ObjectInputStream inputStream = new ObjectInputStream(cipherInputStream);
    SealedObject sealdedObject = (SealedObject) inputStream.readObject();
    System.out.println(sealdedObject.getObject(key));

}
catch(Exception e){
    e.printStackTrace();
}
}
}