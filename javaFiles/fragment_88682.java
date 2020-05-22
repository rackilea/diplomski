public static void main(String[] args) {
  String path = null;
  try (Scanner input = new Scanner(System.in)) {
    System.out.print("Input your option = ");
    int option = input.nextInt();
    switch (option) {
      case 1:
        System.out.println("insert directory file = ");
        String text = "";
        path = input.next();
        FileReader fileReader = new FileReader(path);
        BufferedReader readfile = new BufferedReader(fileReader);
        StringBuffer sb = new StringBuffer();
        try {
          while ((text = readfile.readLine()) != null) {
            sb.append(text);
            sb.append("\n");
          }
          readfile.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
        text = sb.toString();
        System.out.println("Data entered");
        System.out.println("Data length = " + text.length() + "\n");
        break;
      default:
        System.out.println("There is nothing to do.");
        break;
    }
  } catch (FileNotFoundException e1) {
    System.out.println("File not found. Pease insert the proper file directory.");
    System.out.println("Your input path is : " + path);
  }
}