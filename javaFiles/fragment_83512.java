package com.example.stackoverflow;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AESEncryptDecryptNew extends AppCompatActivity {
EditText input_text, password_text;
TextView output_text;
Button enc, dec;
String outputstring;
String AES = "AES";
String pwdtext;
String inptext;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    input_text = (EditText) findViewById(R.id.input_text);
    password_text = (EditText) findViewById(R.id.password_text);
    output_text = (TextView) findViewById(R.id.output_text);
    enc = (Button) findViewById(R.id.encrypt);
    dec = (Button) findViewById(R.id.decrypt);

    enc.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            try {
                inptext = input_text.getText().toString();
                pwdtext = password_text.getText().toString();
                outputstring = encrypt(inptext, pwdtext);
                output_text.setText(outputstring);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });


    dec.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            try {
                inptext = input_text.getText().toString();
                pwdtext = password_text.getText().toString();
                outputstring = decrypt(outputstring, pwdtext);
                output_text.setText(outputstring);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    });
}

private String encrypt(String data, String password_text) throws Exception {
    SecretKeySpec key = generateKey(password_text);
    Log.d("NIKHIL", "encrypt key:" + key.toString());
    Cipher c = Cipher.getInstance("AES/ECB/PKCS5Padding");
    c.init(Cipher.ENCRYPT_MODE, key);
    byte[] encVal = c.doFinal(data.getBytes("UTF-8"));
    String encryptedvalue = Base64.encodeToString(encVal, Base64.DEFAULT);
    return encryptedvalue;

}

private String decrypt(String data, String password_text) throws Exception {
    SecretKeySpec key = generateKey(password_text);
    Log.d("NIKHIL", "encrypt key:" + key.toString());
    Cipher c = Cipher.getInstance("AES/ECB/PKCS5Padding");
    c.init(Cipher.DECRYPT_MODE, key);
    byte[] decodedvalue = Base64.decode(data, Base64.DEFAULT);
    byte[] decvalue = c.doFinal(decodedvalue);
    String decryptedvalue = new String(decvalue, "UTF-8");
    return decryptedvalue;
}

private SecretKeySpec generateKey(String password) throws Exception {
    final MessageDigest digest = MessageDigest.getInstance("SHA-256");
    byte[] bytes = password.getBytes("UTF-8");
    digest.update(bytes, 0, bytes.length);
    byte[] key = digest.digest();
    SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
    return secretKeySpec;
}
}