public class ReadFile {

    static private FileInputStream fstream;
    static private DataInputStream in;
    static private BufferedReader br;
    static private String strLine;
    static private Object[][] words;
    static private int nElems;

    WordsClass wordsClass = new WordsClass(null, null, null, null);

    public ReadFile() {
        words = new Object[14][4];
        nElems = 0;
    }

    public void readnewFile() throws FileNotFoundException {
        fstream = new FileInputStream("highscore.txt");
        in = new DataInputStream(fstream);
        br = new BufferedReader(new InputStreamReader(in));
        // wordRead(); 
    }

    public Object wordRead() throws IOException {
        try {
            while ((strLine = br.readLine()) != null) {
                words[nElems] = strLine.split(" ");
                nElems++;
            }
        } catch (IOException e) {
        }
        br = null;
        in = null;
        fstream = null;
        return words;
    }

    public Object convertToObject() {

        for (Object[] word : words) {
            wordsClass.myObject(word[0].toString(), word[1].toString(), 
                   word[2].toString(), word[3].toString());
        }
        words = null;
        return wordsClass;
    }

    public boolean sortIng() {
        Arrays.sort(wordsClass.finalTest, new Comparator<Object[]>() {
            @Override
            public int compare(final Object[] w1, final Object[] w2) {
                final Integer a = Integer.parseInt(w1[3].toString());
                final Integer b = Integer.parseInt(w2[3].toString());
                return a.compareTo(b);
            }
        });
        return true;
    }

    public void display() {
        for (Object[] finalTest : wordsClass.finalTest) {
            for (Object finalTest1 : finalTest) {
                System.out.print(finalTest1 + " ");
            }
            System.out.println("");
        }
    }
}