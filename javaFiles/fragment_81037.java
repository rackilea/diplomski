@Override
    public Integer totalPages(File file) {

        try(
            InputStream fis = new FileInputStream(file);
            RandomAccessInputStream randomAccessInputStream = new 
            FileCacheRandomAccessInputStream(fis)
        ){

           return TIFFTweaker.getPageCount(randomAccessInputStream);

       }catch(IOException e){


            log.error("Error with Tiff File" + e);
        }

        return null;

    }