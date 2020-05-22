import java.nio.file.*;

public class Test {
    public static void main(String[] args) throws Exception {
        save("By what initials was Franklin Roosevelt better known?", "RED", "wrong");
        save("Which number president was Franklin Roosevelt?", "RED", "wrong");
    }
    public static void save(String question, String userInput, String typeOfAnswer) throws Exception {
        String textToAppend = question + userInput + "," + typeOfAnswer;
        textToAppend += System.lineSeparator();
        Files.write(Paths.get("save.txt"), textToAppend.getBytes(), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
    }
}