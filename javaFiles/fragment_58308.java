import java.io.FileOutputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.Security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.PKCS8Generator;
import org.bouncycastle.openssl.jcajce.JcaPEMWriter;
import org.bouncycastle.openssl.jcajce.JcaPKCS8Generator;
import org.bouncycastle.openssl.jcajce.JceOpenSSLPKCS8EncryptorBuilder;
import org.bouncycastle.operator.OutputEncryptor;
import org.bouncycastle.util.io.pem.PemObject; 

public class WriteOpensslKey {

    public static void main(String[] args) throws Exception {

        // provider is needed for the encryptor builder
        Security.addProvider(new BouncyCastleProvider());

        // generate key pair
        KeyPairGenerator kpGen = KeyPairGenerator.getInstance("RSA");  
        kpGen.initialize(2048, new SecureRandom());  
        KeyPair keyPair = kpGen.generateKeyPair();  

        // construct encryptor builder to encrypt the private key
        JceOpenSSLPKCS8EncryptorBuilder encryptorBuilder = new JceOpenSSLPKCS8EncryptorBuilder(PKCS8Generator.AES_256_CBC);  
        encryptorBuilder.setRandom(new SecureRandom());  
        encryptorBuilder.setPasssword("password".toCharArray());
        OutputEncryptor encryptor = encryptorBuilder.build();  

        // construct object to create the PKCS8 object from the private key and encryptor
        JcaPKCS8Generator pkcsGenerator = new JcaPKCS8Generator(keyPair.getPrivate(), encryptor);  
        PemObject pemObj = pkcsGenerator.generate();  
        StringWriter stringWriter = new StringWriter();  
        try (JcaPEMWriter pemWriter = new JcaPEMWriter(stringWriter)) {  
            pemWriter.writeObject(pemObj);  
        }  

        // write PKCS8 to file
        String pkcs8Key = stringWriter.toString();  
        FileOutputStream fos = new FileOutputStream("<path to output file>");  
        fos.write(pkcs8Key.getBytes(StandardCharsets.UTF_8));  
        fos.flush();  
        fos.close();  

    }

}