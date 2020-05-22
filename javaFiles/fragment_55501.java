public static void main(String[] args) {

     try {
            FileWriter writer = new FileWriter("FSA.txt", true);
            String str = "ababbbabbaabc";
            validate(str);
            writer.write(str);
            writer.close();
        } catch (IOException e) {
            System.out.println("Error");
        }
}

private static void validate(String string) throws IOException {
    if(!string.matches("^[ab]*$"))
      throw new IOException();             
}