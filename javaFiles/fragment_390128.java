File f = null;
    File filepath = null;
    File[] paths;


    try{      
       // create new file
       f = new File("C:/");

       DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();


       // returns pathnames for files and directory
       paths = f.listFiles();


       // for each pathname in pathname array
       for(File file:paths) {
          if(file.getAbsolutePath().contains("Custom Summary Report -- UAT -- "+dateFormat.format(date))) {
             filepath=file;
             System.out.println(filepath);
             break;
          }
       }
    }catch(Exception e){
       // if any error occurs
       e.printStackTrace();
    }


    // Creating Scanner instance to read File in Java
    Scanner scnr = new Scanner(filepath);