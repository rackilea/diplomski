package soQusetion;

import javacard.framework.*;
import javacard.security.AESKey;
import javacard.security.KeyBuilder;
import javacardx.crypto.Cipher;

public class SOQ1 extends Applet {

    Cipher aesCipher;
    AESKey aesKey;

    //Two different types of memory for different usage. each one has 16 (= 0x10) byte capacity.
    private byte[] volatileMem;
    private byte[] nonVolatileMem;

    //INS value for APDU command
    public static final byte INS_SET_KEY = 0x10;
    public static final byte INS_ENCRYPT = 0x20;
    public static final byte INS_DECRYPT = 0x30;

    public static void install(byte[] bArray, short bOffset, byte bLength) {
        new SOQ1();
    }

    protected SOQ1() {
        volatileMem = JCSystem.makeTransientByteArray((short) 0x10, JCSystem.CLEAR_ON_DESELECT);
        nonVolatileMem = new byte[(short) 0x10];
        aesCipher = Cipher.getInstance(Cipher.ALG_AES_BLOCK_128_ECB_NOPAD, false);
        aesKey = (AESKey) KeyBuilder.buildKey(KeyBuilder.TYPE_AES, KeyBuilder.LENGTH_AES_128, false);
        register();
    }

    public void process(APDU apdu) {
        if (selectingApplet()) {
            return;
        }
        byte[] buffer = apdu.getBuffer();
        apdu.setIncomingAndReceive();

        if (buffer[ISO7816.OFFSET_LC] != (byte) 0x10) {
            ISOException.throwIt(ISO7816.SW_WRONG_LENGTH);
        }

        switch (buffer[ISO7816.OFFSET_INS]) {
            case INS_SET_KEY:
                aesKey.setKey(buffer, ISO7816.OFFSET_CDATA);
                break;
            case INS_ENCRYPT:
                aesCipher.init(aesKey, Cipher.MODE_ENCRYPT);
                aesCipher.doFinal(buffer, ISO7816.OFFSET_CDATA, (short) 0x10, volatileMem, (short) 0x00);
                Util.arrayCopyNonAtomic(volatileMem, (short) 0x00, buffer, (short) 0x00, (short) 0x10);
                apdu.setOutgoingAndSend((short) 0x00, (short) 0x10);
                break;
            case INS_DECRYPT:
                aesCipher.init(aesKey, Cipher.MODE_DECRYPT);
                aesCipher.doFinal(buffer, ISO7816.OFFSET_CDATA, (short) 0x10, volatileMem, (short) 0x00);
                Util.arrayCopyNonAtomic(volatileMem, (short) 0x00, buffer, (short) 0x00, (short) 0x10);
                apdu.setOutgoingAndSend((short) 0x00, (short) 0x10);
                break;
            default:
                ISOException.throwIt(ISO7816.SW_INS_NOT_SUPPORTED);
        }

    }
}