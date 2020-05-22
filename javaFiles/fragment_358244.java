InputStream initStream = getClass().getClasLoader().getResourceAsStream("Dataset.csv");
//simplistic approach is to put all the contents of the file stream into memory at once
//  but it would be smarter to buffer and do it in chunks
byte[] buffer = new byte[initStream.available()];
initStream.read(buffer);

//now save the file contents in memory to a temporary file on the disk
//choose your own temporary location - this one is typical for linux
String tempFilePath = "/tmp/Dataset.csv";  
File tempFile = new File(tempFilePath);
OutputStream outStream = new FileOutputStream(tempFile);
outStream.write(buffer);

DataModel model = new FileDataModel(new File(tempFilePath));
...