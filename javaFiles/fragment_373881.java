public class ReadTxtArray {
private final static String filePath = "/home/michael/input.txt";
public static void main(String[] args) {
    try (Scanner s = new Scanner(new BufferedReader(new FileReader(filePath)))) {
        List<List<Character>> rows = new ArrayList<List<Character>>();
        while(s.hasNextLine()) {
            rows.add(createRow(s.nextLine()));
        }
        System.out.println(rows);
    } catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}

private static List<Character> createRow(String line) {
    char[] c = line.toCharArray();
    List<Character> chars = Arrays.asList(ArrayUtils.toObject(c));
    return chars;
}