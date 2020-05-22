try{
    SmbFileInputStream fin = new SmbFileInputStream("smb:" + fileName);
} catch(FileNotFoundException e){
    SmbFileInputStream fin = new SmbFileInputStream("smb:" + fileName);
    //unreachable code
    ...
}