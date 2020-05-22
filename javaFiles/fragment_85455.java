package test;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // initialized before loop
        PrintWriter out = null;
        // proper naming convention
        Frameworkcucc fw = new Frameworkcucc();
        try {
            out = new PrintWriter("valtozok.txt");
        }
        catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // initialized before loop
        Random rand = new Random();
        for (int i = 1; i < 100; i++) {

            System.out.println(i);

            int kiirando = rand.nextInt();

            fw.writetotext(kiirando, out);
        }
        // flushing and closing
        out.flush();
        out.close();
    }

}

class Frameworkcucc {

    public void writetotext(int write, PrintWriter writer) {
        writer.print(write + "\n");
    }
}