Scanner input = new Scanner(System.in);
PrintWriter out = null;
try {
    out = new PrintWriter(new FileWriter(
            "C:/Users/Akram/Documents/akram.txt"));
    System.out.println("Write the Text in the File ");
    while (input.hasNextLine()) {
        String str = input.nextLine();
        out.println(str);
    }
    System.out.println("File created successfuly");
} catch (IOException e) {
    e.printStackTrace();
} finally {
    if (out != null) {
        out.close();
    }
}