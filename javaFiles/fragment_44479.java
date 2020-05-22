public class Driver    {
    private final List<String> arraylist = new ArrayList<String>();
    private final BufferedReader br;

    public Driver() throws FileNotFoundException {
        br = new BufferedReader(new FileReader("data/Catalog.txt"));
    }