import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        String filepath = "./input.txt";
        String removeterm = "1";

        removeRecord(filepath, removeterm);

    }

    private static void removeRecord(String filepath, String removeterm) {
        try {
            List<String> filtered = Files.readAllLines(Paths.get(filepath)).stream().filter(s -> !s.endsWith(removeterm)).collect(Collectors.toList());
            Files.write(Paths.get("./temp.txt"), filtered);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}