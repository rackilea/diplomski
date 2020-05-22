package bom;

import java.io.ByteArrayInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Bom {

    public static void main(String[] args) {
        try {
            new Bom().go();
        } catch (Exception ex) {
            Logger.getLogger(Bom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void go() throws Exception {
        //create data with BOM header:
        byte[] byteArrayBom = {(byte) 0xEF, (byte) 0xBB, (byte) 0xBF, 65, 66, 67};

        ByteArrayInputStream bais = new ByteArrayInputStream(byteArrayBom);
        if (byteArrayBom.length >= 3) {
            //read the first 3 bytes to detect BOM header:
            int b00 = bais.read();
            int b01 = bais.read();
            int b02 = bais.read();
            if (b00 == 239 && b01 == 187 && b02 == 191) { 
                //BOM detected. create new byte[] for bytes without BOM:
                byte[] contentWithoutBom = new byte[byteArrayBom.length - 3];

                //copy byte array without the first 3 bytes:
                System.arraycopy(byteArrayBom, 3, contentWithoutBom, 0, byteArrayBom.length - 3);

                //let's see what we have:
                System.out.println(new String(contentWithoutBom)); //ABC

                for (int i = 0; i < contentWithoutBom.length; i++) {
                    System.out.println(contentWithoutBom[i]); //65, 66 67
                }
            }
        }
    }
}