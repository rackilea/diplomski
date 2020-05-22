File file = new File("DevFile.txt"); // This will create file object with meta info

int ch;
StringBuffer strContent = new StringBuffer("");
FileInputStream fin = null;

try {
fin = new FileInputStream(file); // It'll open a stream and type is input

while ((ch = fin.read()) != -1)// and you can read data stream unless it is closed
strContent.append((char) ch);

fin.close(); // you should close stream to provide safety of your file 

} catch (FileNotFoundException e) {
} catch (IOException ioe) {
}