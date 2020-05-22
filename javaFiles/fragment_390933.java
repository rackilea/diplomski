package com.quratulaind.us3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces; 
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("cv")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
     @GET
     @Produces(MediaType.TEXT_PLAIN)
     public String getIt() {
         return "Got it!";
     }

     @POST
     @Path("/upload")
     @Consumes(MediaType.MULTIPART_FORM_DATA)
     public String uploadCV(
         @FormDataParam("file") InputStream uploadedInputStream,
         @FormDataParam("file") FormDataContentDisposition fileDetail) 
     {
         //saving the file object to the local disk
         saveToDisk(uploadedInputStream, fileDetail);
         return "File Uploaded Successfully";
     }//function uploadcv ends

     //Fuction to save uploaded file to disk
     private void saveToDisk(InputStream uploadedInputStream, 
         FormDataContentDisposition fileDetail) {
         String uploadedFileLocation = "D:\\University Study Stuff\\FYP\\Uploaded CVs For Project"+fileDetail.getFileName();
         try{
             OutputStream out= new FileOutputStream(new File( uploadedFileLocation));
             int read=0;
             byte[] bytes= new byte[1024];
             out=new FileOutputStream( new File(uploadedFileLocation));
             while((read=uploadedInputStream.read(bytes))!= -1){
                 out.write(bytes,0,read);
             }
             out.flush();
             out.close();

          }//try ends
          catch(IOException e)
          {e.printStackTrace();}
      }
  }