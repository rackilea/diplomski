bytesRead = is.read(mybytearray,0,mybytearray.length);
current = bytesRead;
// thanks to A. Cádiz for the bug fix
do {
   bytesRead =
      is.read(mybytearray, current, (mybytearray.length-current));
   if(bytesRead >= 0) current += bytesRead;
} while(bytesRead > -1);