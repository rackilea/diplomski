import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Snippet {
    public static void main(String... args) {
        String filePath = "E:\\Android.html";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            String Word = "Android";
            String[] Words = new String[4];
            Words[0] = "CS";
            Words[1] = "";
            Words[2] = "";
            Words[3] = "";
            List<String> Android = Arrays.asList(Words);
            Collections.shuffle(Android);
            bw.write("<Table align ='center' border = '4'>");
            bw.write("<TR>");
            bw.newLine();
            for (String str : Android) {
                bw.write("<TD width='45'>");
                bw.write(str);
                bw.write("</TD>");
                bw.newLine();
            }
            bw.write("</TR>");
            bw.write("<Table>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}