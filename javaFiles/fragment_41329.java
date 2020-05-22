public class NotFoundException {
}

public interface Loader {
    string load() throws NotFoundException;
}