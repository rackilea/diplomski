import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Date;
import java.util.Iterator;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openpgp.PGPCompressedDataGenerator;
import org.bouncycastle.openpgp.PGPEncryptedDataGenerator;
import org.bouncycastle.openpgp.PGPLiteralData;
import org.bouncycastle.openpgp.PGPLiteralDataGenerator;
import org.bouncycastle.openpgp.PGPPublicKey;
import org.bouncycastle.openpgp.PGPPublicKeyRing;
import org.bouncycastle.openpgp.PGPPublicKeyRingCollection;
import org.bouncycastle.openpgp.PGPUtil;

import com.sap.aii.mapping.api.AbstractTrace;

public class PGPCrypto {

    public void encrypt(String publicKeyPath, InputStream in, OutputStream out, AbstractTrace trace) throws Exception {
        try {
            encrypt(publicKeyPath, inputStreamToString(in), out, trace);
        } catch (Exception e) {
            trace.addInfo(e.getMessage());
            throw new Exception(e.toString());
        }
    }

    public void encrypt(String publicKeyPath, String inString, OutputStream out, AbstractTrace trace) throws Exception {
        try {
            Security.addProvider(new BouncyCastleProvider());
            InputStream keyStream = new FileInputStream(publicKeyPath);
            // Get Publik key
            PGPPublicKey key = readPublicKeyFromCol(keyStream);
            out = new DataOutputStream(out);
            ByteArrayOutputStream bOut = new ByteArrayOutputStream();
            PGPCompressedDataGenerator comData = new PGPCompressedDataGenerator(PGPCompressedDataGenerator.ZIP);
            writeStringToLiteralData(comData.open(bOut), inString);
            comData.close();
            // object that encrypts the data
            trace.addInfo("Trace1: Going to encrypt the data");
            PGPEncryptedDataGenerator cPk = new PGPEncryptedDataGenerator(PGPEncryptedDataGenerator.CAST5, new SecureRandom(),
                    "BC");
            cPk.addMethod(key);
            byte[] bytes = bOut.toByteArray();
            out = cPk.open(out, bytes.length);
            out.write(bytes);
            cPk.close();
            out.close();
        } catch (Exception e) {
            trace.addInfo(e.getMessage());
            throw new Exception(e.toString());
        }
    }

    private String inputStreamToString(InputStream in) {
        // read in stream into string.
        StringBuffer buf = new StringBuffer();
        try {
            InputStreamReader isr = null;
            // try UTF-8 conversion
            try {
                isr = new InputStreamReader(in, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                // or atleast in natural encoding
                isr = new InputStreamReader(in);
            }
            int c = 0;
            while ((c = isr.read()) != -1) {
                buf.append((char) c);
            }
            in.close();
            isr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buf.toString();
    }

    private void writeStringToLiteralData(OutputStream out, String inString) throws IOException {
        PGPLiteralDataGenerator lData = new PGPLiteralDataGenerator();
        OutputStream pOut = lData.open(out, PGPLiteralData.BINARY, "", inString.length(), new Date());
        pOut.write(inString.getBytes());
        lData.close();
    }

    private PGPPublicKey readPublicKeyFromCol(InputStream in) throws Exception {
        PGPPublicKeyRing pkRing = null;
        PGPPublicKey result = null, key = null;
        try {
            PGPPublicKeyRingCollection pkCol = new PGPPublicKeyRingCollection(PGPUtil.getDecoderStream(in));
            Iterator it = pkCol.getKeyRings();
            while (it.hasNext()) {
                pkRing = (PGPPublicKeyRing) it.next();
                Iterator pkIt = pkRing.getPublicKeys();
                while (pkIt.hasNext()) {
                    key = (PGPPublicKey) pkIt.next();
                    if (key.isEncryptionKey()) {
                        result = key;
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.toString());
        }
        return result;
    }
}