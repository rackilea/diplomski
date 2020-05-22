public static void main(String[] args) {
    File file = new File("magicSquare.txt");
     try{
        fileRead(file);
      } catch (FileNotFoundException ex) {
           //exception handling code
      }
  }