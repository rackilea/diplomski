public static String validateXML(String xmlPath){

    BufferedInputStream xmlStream = null;
    try {
        validator = schema.newValidator();
        xmlStream=new BufferedInputStream(new FileInputStream(xmlPath));
        Source src=new StreamSource(xmlStream);
        validator.validate(src);
    } catch (IOException e) {

       // do something
    }
    finally{

        if(xmlStream != null){

            try{
                xmlStream.close();
            }
            catch(Exception e){

               // error while closing
            }            
        }

    }
}