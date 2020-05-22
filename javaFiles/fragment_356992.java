package stackoverflow;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;

public class TipChange {

private static String inputPath = "input.csv";
private static String outputPath = "output.csv";
private static BufferedReader bufferedReader;
private static PrintWriter printWriter;

public static void main(String[] args) {
    try {
        FileInputStream inputStream = new FileInputStream(inputPath);
        Reader reader = new InputStreamReader(inputStream, "UTF-8");
        bufferedReader = new BufferedReader(reader);

        FileOutputStream outputStream = new FileOutputStream(outputPath);
        Writer writer = new OutputStreamWriter(outputStream, "UTF-8");
        printWriter = new PrintWriter(writer);

        String line;

        while ((line = bufferedReader.readLine()) != null) {
            EndeksDegeri eD = lineToClass(line);

            if (shouldOutput(eD)) {
                printWriter.append(classToLine(eD, true));
                printWriter.append(classToLine(eD, false)); 
            }
        }

    } catch (IOException e) {
        e.printStackTrace();
    }
    finally {
        try {
            bufferedReader.close();
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

private static boolean shouldOutput(EndeksDegeri eD) {
    if (!eD.tip.contains(":")) {
        return false;
    }

    return true;
}

private static String classToLine(EndeksDegeri eD, boolean original) {
    if (!original) {
        eD.tip = eD.tip.replace(":", ".");
    }

    return eD.sirket.concat(";")
            .concat(eD.sehir).concat(";")
            .concat(eD.ilce).concat(";")
            .concat(eD.tip).concat(";")
            .concat(String.valueOf(eD.numara)
            .concat("\r\n"));
}

private static EndeksDegeri lineToClass(String line) {
    String[] element = line.split(";");

    EndeksDegeri endeksDegeri = new EndeksDegeri();
    endeksDegeri.sirket = element[0];
    endeksDegeri.sehir = element[1];
    endeksDegeri.ilce = element[2];
    endeksDegeri.tip = element[3];
    endeksDegeri.numara = Integer.valueOf(element[4]);

    return endeksDegeri;
}

private static class EndeksDegeri {
    String sirket ;
    String sehir;
    String ilce;
    String tip;
    int numara;
}
}