//include the file extension
   File file = new File("las.txt");
   String path = file.getAbsolutePath();
   System.out.println(path);

   //pass the file you created to your file reader
   BufferedReader reader = new BufferedReader(new FileReader(file));