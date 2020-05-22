/*
     * 1. How to convert an image file to  byte array?
     */
    try {
        File file = new File("C:/Users/qwerty/Downloads/factura.pdf");

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //create FileInputStream which obtains input bytes from a file in a file system
        //FileInputStream is meant for reading streams of raw bytes such as image data. For reading streams of characters, consider using FileReader.

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        try {
            for (int readNum; (readNum = fis.read(buf)) != -1;) {
                //Writes to this byte array output stream
                bos.write(buf, 0, readNum); 
               // System.out.println("read " + readNum + " bytes,");
            }
        } catch (IOException ex) {
            Logger.getLogger(ARRAYBITStoPDF.class.getName()).log(Level.SEVERE, null, ex);
        }

        byte[] bytes = bos.toByteArray();
        bos.close(); // should be inside a finally block
        //We have the bytes now convert to String

        // ENCODING
        String encodedDoc= Base64.getEncoder().encodeToString(bytes);

        System.out.println(encodedDoc);

        // DECODING
        int size = bytes.length;
        InputStream isfilecontent = null;
        //byte[] b = new byte[size];
        isfilecontent = new ByteArrayInputStream(Base64.getDecoder().decode(encodedDoc));

        //writing the downloaded data into a PDF file
         FileOutputStream fileOutputpdf = new FileOutputStream("C:/Users/qwerty/Downloads/myfactura.pdf");

         /* use binary I/O to prevent line based operation messing with the encoding.*/
         byte[] buf2 = new byte[2048];
         int b_read = 0;
         while ( (b_read = isfilecontent.read(buf2)) > 0) {
             fileOutputpdf.write(buf2, 0, b_read);
         }
         fileOutputpdf.flush();
         //closed the output stream
         fileOutputpdf.close();

     } catch (IOException e) {
        // handle IOException
         System.out.println(e.getMessage());
    }