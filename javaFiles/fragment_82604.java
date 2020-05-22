for (S3ObjectSummary s3ObjectSummary : summaries) 
{
    String key = s3ObjectSummary.getKey();//getting the key of the item
    S3Object object = s3.getObject(
              new GetObjectRequest(incommingBucket, key));
    InputStream mailFileInputStream = object.getObjectContent();
    String bucketKey = object.getKey();
    MimeMessage message = getMimeMessageForRawEmailString(mailFileInputStream);//converting input stream to mime message
    object.close();
}

public MimeMessage getMimeMessageForRawEmailString(InputStream mailFileInputStream) throws Exception
{
    Properties props = new Properties();
    Session session = Session.getDefaultInstance(props, null);
    MimeMessage message = new MimeMessage(session, mailFileInputStream);
    return message;
}