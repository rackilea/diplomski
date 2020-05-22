byte[] filebuffer = new byte[8192];
int read = 0;
while(( read = fis.read(filebuffer)) > 0){
    dos.write(filebuffer,0,read);
    dos.flush();
}