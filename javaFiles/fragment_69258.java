public static byte[] add(byte[] data1, byte[] data2) {
  if(data1.length!=32 || data2.length!=32)
    throw new IllegalArgumentException();
  byte[] result=new byte[32];
  for(int i=31, overflow=0; i>=0; i--) {
    int v = (data1[i]&0xff)+(data2[i]&0xff)+overflow;
    result[i]=(byte)v;
    overflow=v>>>8;
  }
  return result;
}