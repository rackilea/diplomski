org.apache.commons.net.ftp.FTPClient ftpClient=new FTPClient();  //instantiate the FTPClient
FTPFile[] ftpFiles=ftpClient.listFiles();//get the list of files in the root directory of the FTP server
for(FTPFile tempFtpFile:ftpFiles)
{
  //go through the list of files and delete those that start with your required prefix
  String tempFtpFileName=tempFtpFile.getName();
  if(tempFtpFileName.startsWith(productID+setFileName))
   ftpClient.deleteFile(tempFtpFile.getName());
}