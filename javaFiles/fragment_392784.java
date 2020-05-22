public class Main
{
    private static void writeFile(String fileName) throws FileNotFoundException
    {
        Formatter file = null;
        try {
            file = new Formatter(fileName);
            file.format("%s %s", "Hello", "World");
        } finally {
            if (file != null) {
                file.close();
            }
        }
    }

    private static void readFile(String fileName) throws FileNotFoundException
    {
        Scanner sc = null;
        try {
            sc = new Scanner(new FileInputStream(fileName));
            while (sc.hasNext()) {
                System.out.println(sc.next());
            }
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
    }

    public static void main(String[] args)
    {
        final String fileName = "test.txt";
        try {
            writeFile(fileName);
            readFile(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}