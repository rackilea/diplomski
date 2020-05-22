String existingfile = "abc.jpg";
String newfile = "123.jpg";
FileDirectory = "/appl/user/home/test/";
sftp.cd(FileDirectory+"temp/");
if (sftp.get( newfile ) != null){
    sftp.rename(FileDirectory + "temp/" + newfile , 
        FileDirectory + newfile );
    sftp.cd(FileDirectory);
    sftp.rm(existingfile );
}