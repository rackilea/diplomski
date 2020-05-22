public static void main(String[] args ){   


    File f = new File("ahh#.txt");    

try {
    if(f.createNewFile()){
        System.out.println("ok"+ f.getAbsolutePath());
    }
} catch (IOException ex) {
    Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
}
   // file with string path 
   FileInputStream fis0;
    try {
        fis0 = new FileInputStream(
                new File(f.getAbsolutePath()));
    } catch (FileNotFoundException ex) {
        System.out.println("file not found with string");
    }

    try {
        try {
            // file with URI
            FileInputStream fis1 =
                    new FileInputStream(
                            new File(
                                    new URI(f.getAbsolutePath())));
        } catch (URISyntaxException ex) {
            System.out.println("URI???");
        }
    } catch (FileNotFoundException ex) {
        System.out.println("file not found with URI");
    }


}