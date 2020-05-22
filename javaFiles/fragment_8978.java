String s3Bucket = "test_bucket";
String s3FileName = "test_file.txt";
String localFileName = "C:\\Users\\ABC\\Desktop\\test_file.txt";    
File file = new File(localFileName);

s3.putObject(new PutObjectRequest(s3Bucket, s3FileName, file ));