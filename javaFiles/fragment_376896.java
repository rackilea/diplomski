public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("fileAscii")); // to read a single line from the file
        int read;
        String src= new String();       // to store the string obtained from buffered reader
        PrintWriter writer= new PrintWriter("fileOutput");
        src=br.readLine();              // read an input line from the file

        while(src!=null){
            src=src.replace(" ", "");   // Trim out the spaces
            for(int i=0;i<src.length();i+=2){
                read=Integer.parseInt(src.substring(i,i+2), 16);    // convert the String to hex integer 
                writer.print((char)read);                           // convert hex to char and write into file
            }
            src=br.readLine();
        }
        writer.flush();
    }