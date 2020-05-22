Media media = new Media();
//set stuff on my Media object for storing info about the file in the DB
//....
if (chunks > 0 && chunk > 0)
{
    //Need to append the bytes in this chunk
    mediaRepository.appendBytes(media, file.getBytes());
    if (chunk == chunks - 1)
    {
        //last chunk, upload is done
        onUploadFinished(media);
    }
}
else
{
    //Write out the first set of bytes
    mediaRepository.saveBytes(media, file.getBytes());
    if (chunks <= 0)
    {
        //no chunks were needed, all the bytes have been written out, upload is done
        onUploadFinished(media);
    }
}