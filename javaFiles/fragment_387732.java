public static void writeBlock(OutputStream stream, float[] data, byte startPosition)
{
  int i = 0;

  //Bitstream bitstream init

  for(i = startPosition; i < data.length; i++)
  {
     // Code
     stream.flush();
     stream.write(someByte); // throws Exception at second call
     if(someCondition)
     {
        break;
     }
  }
  bitstream.close();
  stream.flush();
  if(i < data.length)
  {
     writeBlock(stream, data, i)
  }
}