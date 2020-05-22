@POST
  @Consumes(MediaType.MULTIPART_FORM_DATA)
  public void upload(FormDataMultiPart formParams){

    Map<String, List<FormDataBodyPart>> fieldsByName =   formParams.getFields();

       for (List<FormDataBodyPart> fields : fieldsByName.values()) {
            for (FormDataBodyPart field : fields){

 // Check if fields are files(If any one knows better solution to check files[] please share your answers)

                if (StringUtils.equals("files",
                  StringUtils.substringBefore(field.getName(), "["))) {

                    //To read file content
                    InputStream is = field.getEntityAs(InputStream.class);
                    String fileName = field.getName();
                    field.getMediaType();//File mimeType

                    //To get file details like size,file name,etc
                    FormDataContentDisposition f=field.getFormDataContentDisposition();
                    System.out.println(f.getFileName());

    Note: f.getType() not return the actual file type it returns mime type as   form-data to get actual mime type use FormDataBodyPart media type like above.
     }

    get other form data like user name

  else if(StringUtils.equals(field.getName(),"userName")){

          System.out.println(field.getValue());
       }
     }
   }
 }