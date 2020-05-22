import java.io.*;;
import java.util.Scanner;
class Main {
    public static void main(String args[]) {
        try {
            String content = new Scanner(new File("data.txt")).useDelimiter("\\Z").next();
            String split[] = content.split("( )|(\n)");
            try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("output.txt"), "utf-8"))) {
                for (int i = 0; i < split.length; i++) {
                    if (split[i].equals("qwee")) {
                        writer.write("qwee " + split[i + 3] + "\n");
                    }
                    if (split[i].equals("deff")) {
                        writer.write("deff  " + split[i + 3] + "\n");
                    }                    ;
                }
                writer.close();
            } catch (Exception e) {
                e.printStackTrace();                ;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}