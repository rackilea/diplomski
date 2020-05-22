out.write("GET "+ path +" HTTP/1.1\r\nHost: "+ host +"\r\nConnection: close\r\n\r\n");
out.flush();

int dataBuffer;
while ((dataBuffer = connection.getInputStream().read()) != -1) 
   System.out.print((char)dataBuffer);

out.close();