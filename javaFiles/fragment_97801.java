package com.example;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.StringArray;
import com.sun.jna.Structure;

public class Example {

    public interface CLibrary extends Library {

        public static class Topic extends Structure {
            public static class ByReference extends Topic implements Structure.ByReference {
            }

            public String src_id;
            public String dest_id;
            public int num;

            public int numVals;
            public Pointer names; // char**

            @Override
            protected List<String> getFieldOrder() {
                return Arrays.asList(new String[] { "src_id", "dest_id", "num", "numVals", "names" });
            }
        }

        public void sendTopic(Topic.ByReference pVal);
    }

    public static void main(String[] args) {

        final CLibrary clib = Native.loadLibrary("example.dll", CLibrary.class);

        final String[] myArray = new String[5];
        myArray[0] = "one";
        myArray[1] = "two";
        myArray[2] = "three";
        myArray[3] = "four";
        myArray[4] = "five";

        CLibrary.Topic.ByReference ref = new CLibrary.Topic.ByReference();
        ref.numVals = 5;
        ref.names = new StringArray(myArray);

        clib.sendTopic(ref);
    }
}