public class Inputfile {    

      public static String getFileName() throws Exception  {
        Scanner sc = new Scanner(System.in);
        String fileName = null;
        boolean isFile = false;
        while (!isFile){   
            System.out.print("Input file name? ");
            fileName = sc.next();

            File inputFile = new File(fileName);
            if (inputFile.exists()){
                isFile = true;
            }            
        } 
        return fileName;
    }
}