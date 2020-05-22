public class Main{

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String argv[]) throws IOException{
        new YourClass(reader,System.out).run();
    }
}

public class YourClass { // I don't know what your class is actually doing, but name it something appropriate
  private final InputReader reader;
  private final PrintStream output;

  public YourClass(InputReader reader, PrintStream output) {
       this.reader = reader;
       this.output = ouptut;
  }

  public void run() {

        while (true) {
        char input = (char) reader.read();

        if(input == 'x')
            return;

        output.println(input);
  }
}