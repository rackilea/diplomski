public class Map {

    private TreeMap<String, String> pairs;

    public Map() {
        pairs = new TreeMap<String, String>();
    }

    public void readFrom(String fileName) {
        try {
            Scanner input = new Scanner(new File(fileName));
            while (input.hasNextLine()) {
                String [] parts = input.nextLine().split(",");
                if (parts.length == 2)
                    pairs.put(parts[0], parts[1]);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(-1);
        }
    }

    public String get(String key) {
        return pairs.get(key);
    }

    public static void main(String[] args) {
        Map USA = new Map();
        USA.readFrom("states_and_capitals.txt");

        System.out.print("Enter a state: ");
        Scanner input = new Scanner(System.in);
        System.out.println(USA.get(input.nextLine()));
    }
}