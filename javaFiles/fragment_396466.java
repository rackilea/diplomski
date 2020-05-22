try {
        InputStream stream = abjjadDb.getBookStream(bookEditionID);
        if( stream == null) return null;

        final ZipInputStream zip = new ZipInputStream(stream);

        ZipEntry entry;
        do {
            entry = zip.getNextEntry();
            if( entry == null) {
                zip.close();
                return null;
            }
        } while( !entry.getName().equals(zipEntryName));

        data.contentLength = entry.getSize();
        data.lastModified = entry.getTime();
        data.contentPath = contentPath;

        InputStream s = zip;
        if( data.contentLength == -1) {
            Log.e("demo",new Object(){}.getClass().getEnclosingMethod().getName()+":: entry \""+entry+"\" has contentLength -1, so we will work around");
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            int nRead;
            // use buf to store data from the zip file entry in fixed size
            byte[] buf = new byte[4096];
            while ((nRead = zip.read(buf)) != -1) {
                // dump that data into buffer, which is a growing buffer
                buffer.write(buf, 0, nRead);
            }
            buffer.flush();

            byte[] finalBuffer = buffer.toByteArray();
            Log.e("demo",new Object(){}.getClass().getEnclosingMethod().getName()+":: entry \""+entry+"\" final data length: "+finalBuffer.length);
            data.contentLength = finalBuffer.length;
            s = new ByteArrayInputStream(finalBuffer);
        }
        final InputStream finalStream = s;