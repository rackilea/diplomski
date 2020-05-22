public interface MyIO{
    public String readLine();
}

public class MyBr extends BufferedReader implements MyIO{}

public class MyCSV extends CSVReader implements MyIO{}