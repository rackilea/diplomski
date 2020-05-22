public static void main (String args[]) throws java.io.IOException {
      String line;
      Scanner sc = new Scanner(System.in);
      do {
          System.out.println("Please a key followed by ENTER:");
          line = sc.readLine().trim();
      } while (!"q".equals(line));
  }