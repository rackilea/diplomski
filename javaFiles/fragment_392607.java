public static void main(String args[]) throws IOException {

int i;
FileInputStream fin = new FileInputStream("files.txt");
String n = "";

do {
     i = fin.read();
     n += (char) i;
   } while(i != -1);

   fin.close();
//String n now contains the contents of the file
}