public class Test {
public static void main(String [] args) {

    File file = new File("test.txt");
    int counter = 0;
    try {

        int ch;
        for (char a : "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray()) {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            char toSearch = a;
            counter = 0;

            while ((ch = reader.read()) != -1) {
                if (a == Character.toUpperCase((char) ch)) {
                    counter++;
                }
            }
            System.out.println(toSearch + " occurs " + counter);

        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }

}