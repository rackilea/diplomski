public class main {

    public static void main(String[] args) throws IOException {
        String fileName = "C:/Users/kang/Downloads/yukim.txt";
        List<String> newLines = new ArrayList<>();
        int i = 85; // <- you lack this one, start from 85 and not 0 since there are already lines that has value and the last one is 84
        for (String line : Files.readAllLines(Paths.get(fileName), StandardCharsets.ISO_8859_1)) {
             if (line.contains("INSERT INTO yukim_720 VALUES ( ''")) {        

                         newLines.add(line.replace("INSERT INTO yukim_720 VALUES ( '",    "INSERT INTO yukim_720 VALUES ( '"+(i++))); // this line was edited
                    } else {
                       newLines.add(line);
                    }                     
        }
        Files.write(Paths.get(fileName), newLines, StandardCharsets.ISO_8859_1);

    }
}