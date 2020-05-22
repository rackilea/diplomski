public interface IInterface extends Comparable<IInterface>{    
    String getContent(String filepath) throws DumbException;
}

public class InterfaceClass implements IInterface{
    public String getContent(String filepath) throws DumbException {
        // use filepath to get the file's content
    }
}