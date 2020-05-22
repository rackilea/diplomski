package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class ObjectWrite {

    static class contoCorrente implements Serializable {

        public contoCorrente(String string, int k, int l) {
            name = string;
            i = k;
            j = l;
        }

        String name;
        int i;
        int j;
    }

    public static void main(String[] args) throws Exception {
        ArrayList<contoCorrente> contiCorrentiArray = null;
        File file = new File("contiCorrenti");
        if (file.exists()) {
            FileInputStream fileIn = new FileInputStream(file);
            ObjectInputStream fileObjIn = new ObjectInputStream(fileIn);

            contiCorrentiArray = (ArrayList<contoCorrente>) fileObjIn.readObject();

            fileObjIn.close();
            fileIn.close();
        } else {
            contiCorrentiArray = new ArrayList<contoCorrente>();
        }

        System.out.println("Size of List at start: "+contiCorrentiArray.size());

        contoCorrente c1 = new contoCorrente("IDNALFO", 14, 1);
        contoCorrente c2 = new contoCorrente("IDNALFO", 14, 3);

        contiCorrentiArray.add(c1);

        FileOutputStream fileOut = new FileOutputStream(file);
        ObjectOutputStream fileObj = new ObjectOutputStream(fileOut);

        fileObj.writeObject(contiCorrentiArray);
        fileObj.close();
        fileOut.close();
    }

}