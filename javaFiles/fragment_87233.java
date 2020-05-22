File f = new File("your folder path here");// your folder path

//**Edit** It is array of Strings
String[] fileList = f.list(); // It gives list of all files in the folder.

for(String str : fileList){
    if(str.endsWith(".jack")){

        // Read the content of file "str" and store it in some variable

         FileReader reader = new FileReader("your folder path"+str);
        char[] chars = new char[(int) new File("your folder path"+str).length()];
        reader.read(chars);
       String content = new String(chars);
        reader.close(); 

        // now write the content in xml file

         BufferedWriter bw = new BufferedWriter(
         new FileWriter("you folder path"+str.replace(".jack",".xml")));
         bw.write(content); //now you can  write that variable in your file.

         bw.close();
   }
}