public static void Message(String s) throws IOException {
   File file = new File("put_the_path_of_your_file_here");
   FileWriter fileWriter = new FileWriter(file);

   fileWriter.write(s);
   fileWriter.flush();
   fileWriter.close();
}