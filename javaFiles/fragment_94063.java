public class Words {
Scanner in;
public Words(String filename) throws FileNotFoundException {
    File inFile = new File(filename);
    in = new Scanner(inFile);
}
............
}