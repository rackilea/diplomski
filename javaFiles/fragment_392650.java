byte[] localbyte = null;
if(nbytes != null)
{
    String[] arr = (nbytes.split(" ")); 
    localbyte = new byte[arr.length];  
    for (int i=0;  i<localbyte.length;  i++) {
        localbyte[i] = new Byte(arr[i]);  
    }
}