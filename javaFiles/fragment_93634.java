long maxByteArraySize() {
   long size = Integer.MAX_VALUE;
   while(--size > 0) try {
        new byte[size];
        break;
   } catch(Throwable t) {}   
   return size;
}