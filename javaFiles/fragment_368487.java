int megabytesCount = 10;
    try(GZIPInputStream gzipInputStream = new GZIPInputStream(yourFileInputStream))
    {
        bytes[] buffer = new bytes[megabytesCount * 1024];
        int bytesRead = -1;
        if(( bytesRead = gzipInputStream.read(buffer)) = -1)
        {
            // do Something with your buffer and its current size n; 
        }
    }catch(Expection blahBlah){

    }