//Get the servers upload directory real path name
          filepath = getServletContext().getRealPath("/")+"xml_upload";
          System.out.println("The file path is "+filepath);
          //create the upload folder if not exists
           File folder = new File(filepath);
           if(!folder.exists())
           {
            folder.mkdir();
           }


     MultipartRequest m=new MultipartRequest(req,filepath);
     ff=m.getFile("f");
     System.out.println("Full Path with file name:"+ff);
     //get file name...
     filename=ff.getName();
     System.out.println("file name is:"+filename);

      //now here you have to get the file name without extension and then append the extension .tmp
 // now let the file is represented by a File object say ff .....

   if(ff.exists())
          {
           System.out.println("File exist and it is going to delete.");
           ff.delete() ;
           }