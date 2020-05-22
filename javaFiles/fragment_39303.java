public class UserInputReader {
    private final Class<?> clazz;
    private Object userInput;

    public userInputReader(final Class<?> clazz) throws IOException {
        this.clazz = clazz;
        readUserInput();
    }

    ...