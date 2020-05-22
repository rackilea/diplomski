public static byte[] unzipByteArray(byte[] file) throws IOException {

    // create a buffer to improve copy performance later.
    byte[] buffer = new byte[2048];
    byte[] content ;

    // open the zip file stream
    InputStream theFile = new ByteArrayInputStream(file);
    ZipInputStream stream = new ZipInputStream(theFile);
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    try
    {

        ZipEntry entry;
        while((entry = stream.getNextEntry())!=null)
        {
            //String s = String.format("Entry: %s len %d added %TD", entry.getName(), entry.getSize(), new Date(entry.getTime()));
            //System.out.println(s);

            // Once we get the entry from the stream, the stream is
            // positioned read to read the raw data, and we keep
            // reading until read returns 0 or less.
            //String outpath = outdir + "/" + entry.getName();

            try
            {
                //output = new FileOutputStream(outpath);

                int len = 0;
                while ((len = stream.read(buffer)) > 0)
                {
                    output.write(buffer, 0, len);
                }
            }
            finally
            {
                // we must always close the output file
                if(output!=null) output.close();                                            
            }
        }            
    }
    finally
    {
        // we must always close the zip file.
        stream.close();            
    }
    content = output.toByteArray();

    return content;     

}