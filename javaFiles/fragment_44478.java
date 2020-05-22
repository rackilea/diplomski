public class Driver {
    private final List<String> arraylist = new ArrayList<String>();
    {
        try {
            BufferedReader br = new BufferedReader(new FileReader("data/Catalog.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }