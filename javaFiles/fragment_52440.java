import java.util.*;
import java.io.*;
import java.util.regex.*;

public class T {
    public static Collection<String> findHung(Iterable<String> data) {
        Pattern p = Pattern.compile(
            "ScriptExecThread\\(([0-9]+).*?(finished|starting)");
        HashMap<Integer, String> running = new HashMap<Integer, String>();
        for (String d : data) {
            Matcher m = p.matcher(d);
            if (m.find()) {
                int n = Integer.parseInt(m.group(1));
                if (m.group(2).equals("starting"))
                    running.put(n, d);
                else
                    running.remove(n);
            }
        }
        return running.values();
    }

    static Iterable<String> readFile(String path, String encoding) throws IOException {
        final Scanner sc = new Scanner(new File(path), encoding).useDelimiter("\n");
        return new Iterable<String>() {
            public Iterator<String> iterator() { return sc; }
        };
    }

    public static void main(String[] args) throws Exception {
        for (String fileName : args) {
            for (String s : findHung(readFile(fileName, "UTF-8"))) {
                System.out.println(fileName + ": '" + s + "' unfinished");
            }
        }
    }
}