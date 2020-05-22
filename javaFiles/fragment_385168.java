private static int count = 0;

public static void record(Message  message)//Message is a class 
    {
    try
      {
        BufferedOutputStream buf=new BufferedOutputStream(
          new FileOutputStream("E:/kruthika/proj/" + count + ".bin")
        );
        byte[] b =serializer.serialize(message);        
        buf.write(b);
        buf.flush();

        count++;

      }
    catch(Exception e){System.out.print(e);}
  }