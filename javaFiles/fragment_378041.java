byte[] buffer = new byte[4];
FileInputStream fis = new FileInputStream("H://Sample_Word.docx");  
int read = fis.read(buffer);
if (read != buffer.length) {
    System.out.println("Short file!");
}