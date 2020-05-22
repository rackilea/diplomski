int count = 0;
while (count < 16380) {
      int incoming = in.read(bytes);
      System.out.println("v  : " + incoming);

      if (incoming > 0) {
        out.write(bytes, 0, incoming); 
        count += incoming;
      } else if (incoming < 0) {
        //end of stream
        break; 
      }
}