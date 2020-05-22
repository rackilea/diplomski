private void writeDir(File f){
    try{
         if(f.mkdirs()) { 
             System.out.println("Directory Created");
        } else {
        System.out.println("Directory is not created");
        }
    } catch(Exception e){
            //  Demo purposes only.  Do NOT do this in real code.  EVER.
            //  It squashes exceptions ...
        e.printStackTrace();
    }
}