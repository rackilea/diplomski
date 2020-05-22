@SuppressWarnings("unchecked")
            @POST
            @Path("/UploadProfileImage")
            @Consumes(MediaType.APPLICATION_OCTET_STREAM) 
            @Produces(MediaType.APPLICATION_JSON)
            public String uploadProfileImage(@FormDataParam("file")InputStream uploadedImageInputStream,@HeaderParam("mPolicyGroupSeqId")String PolicyGroupSeqId){

                JSONArray arra = new JSONArray();           
                LinkedHashMap<String, String> mapObject = new LinkedHashMap<String, String>();

                try {



                    System.out.println("upload profile image");
                    String strPolicyGroupSeqId=TTKCommon.checkNull(PolicyGroupSeqId);

                    WebServiceManager webServiceManager=this.getWebServiceManagerObject();

                    System.out.println("mPolicyGroupSeqId      "+PolicyGroupSeqId);

                    byte[] bytes = new byte[1024];  

                    bytes   =   org.apache.commons.io.IOUtils.toByteArray(uploadedImageInputStream);

                    /*
                    String filePath = "D:/Download Here/hello.png";

                    FileOutputStream fos = new FileOutputStream(filePath);
                    BufferedOutputStream outputStream = new BufferedOutputStream(fos);
                    outputStream.write(bytes);

                    fos.flush();
                    fos.close();
                    outputStream.flush();
                    outputStream.close();*/

                    System.out.println("kbbsssssssssss  "+bytes.length);





                    int status=webServiceManager.uploadProfileImageonSubmit(strPolicyGroupSeqId,bytes,1);     



                    if(status==1){
                        mapObject.put("status", "P");
                        mapObject.put("message","Profile Picture Uploaded Successfully");
                    }else{
                        mapObject.put("status", "F");
                        mapObject.put("error_message","Profile Picture Not Uploaded Successfully");

                    }

                    System.out.println(status);

                }//end of try 



                catch (TTKException tte) {              
                    tte.printStackTrace();
                    try{
                        String errorMsg="!Error While Uploading ProfilePicture ...";
                        mapObject.put("status", "F");
                        mapObject.put("error_message",errorMsg);        
                    }catch(Exception ie) {
                        ie.printStackTrace();
                        mapObject.put("status", "F");
                        mapObject.put("error_message", "!Error While Uploading ProfilePicture Data ...");   
                    }

                }catch (Exception e) {
                    e.printStackTrace();
                    mapObject.put("status", "F");
                    mapObject.put("error_message", "!Error While Uploading ProfilePicture Data...");                
                }

                arra.put(mapObject);
                return arra.toString();


            }   //end of uploadProfileImage