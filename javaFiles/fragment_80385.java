public DDHLogger(String filePath, String yourfilename) 
{
    System.out.println("filePath: " + filePath);
    System.out.println("yourfilename: " + yourfilename);
     //String fileName = "C:\\Users\\home-1\\Desktop\\" + yourfilename;
     String fileName = filePath + yourfilename;
     System.out.println("fileName::--> " + fileName);
    // file = new File(fileName);//Creates the file
     file = new File(fileName);//Creates the file
     System.out.println("file: " + file);
     try {
        fw = new FileWriter(file, true);
        //INSTANTIATE PRINTWRITER HERE
        pw = new PrintWriter(fw);
    } catch (IOException e) {
        e.printStackTrace();
    }//allows append to the file without over writing. The TRUE keyword is used for append

}