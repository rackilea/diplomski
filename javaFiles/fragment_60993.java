package test;

import java.io.IOException;

    public class ArgsTest {

        public static void main(String[] args) throws IOException {

            System.out.println("Program Arguments:");
            for (String arg : args) {
                System.out.println("\t" + arg);
            }

            System.out.println("System Properties from VM Arguments");
            String sysProp1 = "sysProp1";
            System.out.println("\tName:" + sysProp1 + ", Value:" + System.getProperty(sysProp1));
            String sysProp2 = "sysProp2";
            System.out.println("\tName:" + sysProp2 + ", Value:" + System.getProperty(sysProp2));

        }
    }