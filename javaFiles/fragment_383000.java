String path="c:/newDirectory";
 File file=new File(path);
 if(!file.exists())
     file.mkdirs(); // or file.mkdir()

 file=new File(path + "/" + Utilities.timeFormat());   
 if(file.createNewFile())
  {
  }