//UPLOADING A CONTENT TO THE SERVER

package org.ofbiz.productionmgntSystem.web_app_req;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.io.FileOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.ofbiz.service.ServiceUtil;
import java.util.List;

public class Uploading
{
    public static String uploadFile(HttpServletRequest request,HttpServletResponse response)
    {
        //ServletFileUpload fu = new ServletFileUpload(new DiskFileItemFactory(10240, new File(new File("runtime"), "tmp")));           //Creation of servletfileupload
        System.out.println("\n\n\t****************************************\n\tuploadFile(HttpServletRequest request,HttpServletResponse response) - start\n\t");
        ServletFileUpload fu = new ServletFileUpload(new DiskFileItemFactory());           //Creation of servletfileupload
        java.util.List lst = null;
        String result="AttachementException";
        String file_name="";
        try 
        {
            lst = fu.parseRequest(request);
        }
        catch (FileUploadException fup_ex) 
        {
            System.out.println("\n\n\t****************************************\n\tException of FileUploadException \n\t");
            fup_ex.printStackTrace();
            result="AttachementException";
            return(result);
        }

        if(lst.size()==0)        //There is no item in lst
        {
            System.out.println("\n\n\t****************************************\n\tLst count is 0 \n\t");
            result="AttachementException";
            return(result);
        }


        FileItem file_item = null;
        FileItem selected_file_item=null;

        //Checking for form fields - Start
            for (int i=0; i < lst.size(); i++) 
            {
                file_item=(FileItem)lst.get(i);
                String fieldName = file_item.getFieldName();

                //Check for the attributes for user selected file - Start
                    if(fieldName.equals("filename"))
                    {
                        selected_file_item=file_item;
                        //String file_name=file_item.getString();                       
                        //file_name=request.getParameter("filename");
                        file_name=file_item.getName();             //Getting the file name
                        System.out.println("\n\n\t****************************************\n\tThe selected file item's file name is : "+file_name+"\n\t");
                        break;
                    }
                //Check for the attributes for user selected file - End
            }
        //Checking for form fields - End

        //Uploading the file content - Start
            if(selected_file_item==null)                    //If selected file item is null
            {
                System.out.println("\n\n\t****************************************\n\tThe selected file item is null\n\t");
                result="AttachementException";
                return(result);
            }

            byte[] file_bytes=selected_file_item.get();
            byte[] extract_bytes=new byte[file_bytes.length];

            for(int l=0;l<file_bytes.length;l++)
                extract_bytes[l]=file_bytes[l];
            //ByteBuffer byteWrap=ByteBuffer.wrap(file_bytes);
            //byte[] extract_bytes;
            //byteWrap.get(extract_bytes);


            //System.out.println("\n\n\t****************************************\n\tExtract succeeded :content are : \n\t");


            if(extract_bytes==null)
            {
                System.out.println("\n\n\t****************************************\n\tExtract bytes is null\n\t");
                result="AttachementException";
                return(result);
            }

            /*
            for(int k=0;k<extract_bytes.length;k++)
                System.out.print((char)extract_bytes[k]);
            */

            //String target_file_name="/hot-deploy/productionmgntSystem"
            //Creation & writing to the file in server - Start              
                try
                {
                    FileOutputStream fout=new FileOutputStream(file_name);
                    System.out.println("\n\n\t****************************************\n\tAfter creating outputstream");
                    fout.flush();
                    fout.write(extract_bytes);
                    fout.flush();
                    fout.close();
                }
                catch(IOException ioe_ex)
                {
                    System.out.println("\n\n\t****************************************\n\tIOException occured on file writing");
                    ioe_ex.printStackTrace();
                    result="AttachementException";
                    return(result);
                }
            //Creation & writing to the file in server - End

            System.out.println("\n\n\t****************************************\n\tuploadFile(HttpServletRequest request,HttpServletResponse response) - end\n\t");
            return("AttachementSuccess");
        //Uploading the file content - End
    }
}