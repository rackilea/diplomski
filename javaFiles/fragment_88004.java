FileInputStream fis = new FileInputStream(fil);
BufferedInputStream in = new BufferedInputStream(fis);
BufferedOutputStream out = new BufferedOutputStream(skt.getOutputStream());

//Write the file to the server socket
int i;
int written = 0;
byte[] buf = new byte[512];

while ((i = in.read(buff)) != -1) {  

    out.write(buff,0,i);
    written += i;
    publishProgress((double)written/length);
    //passing a double value from 0-1 to say how much is transmitted (length is length of file)
    System.out.println(buff+", "+i);
}