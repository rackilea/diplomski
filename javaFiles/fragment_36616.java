try{
         String fileName = request.getParameter("image");             
         FileInputStream fis = new FileInputStream(new File("d:\\"+fileName));
         BufferedInputStream bis = new BufferedInputStream(fis);             
         response.setContentType(contentType);
         BufferedOutputStream output = new BufferedOutputStream(response.getOutputStream());
         for (int data; (data = bis.read()) > -1;) {
           output.write(data);
         }             
      }
      catch(IOException e){

      }finally{
          // close the streams
      }