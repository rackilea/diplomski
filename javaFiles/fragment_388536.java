import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

class Instruction {
    private String clientName;
    private Boolean flag;

    public Instruction(String clientName, Boolean flag) {
        super();
        this.clientName = clientName;
        this.flag = flag;
    }

    @Override
    public String toString() {

        return String.format("ClientName : %s, Flag : %s", this.clientName,
                this.flag);
    }
}

public class App {

    static BiFunction<String, Boolean, Instruction> createInstrucationFn = (
            client, flag) -> new Instruction(client, flag);

    public static void main(String[] args) throws IOException {

        String inputFileName = "e:/input/instruct.csv";

        List<String> dataLine = Files.readAllLines(Paths.get(inputFileName));

        List<Instruction> instructionList = dataLine
                .stream()
                .map(line -> {
                    String[] pairs = line.split(",");
                    return createInstrucationFn.apply(pairs[0], Boolean.valueOf(pairs[1]));
                }).collect(Collectors.toList());

        instructionList.forEach(System.out::println);

    }
}