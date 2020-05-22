public class Tester implements Runnable {

    String line = null;

    public static void main(String[] args) throws IOException {
        BufferedReader fileR = new BufferedReader(new FileReader("UsernameList.txt"));
        String line = null;
        while ((line = fileR.readLine()) != null) {
            Tester tester = new Tester();
            tester.line = line;
            Thread thread = new Thread(tester);
            thread.start();
        }

    }

    @Override
    public void run() {
        Document doc = Jsoup.connect("https://twitter.com/" + line).get();
        doc.html();
    }
}