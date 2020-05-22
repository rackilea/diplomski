public class MyClass {

   private static FileChannel RqstChnl = null; 
   private static ByteBuffer Rqst_Bufr = null; 

   // ...

   public static void ConnectFiles throws IOException { 
     FileInputStream RqstInp = new FileInputStream(Rqst_File) ; 
     RqstChnl  = RqstInp.getChannel() ; 
     Rqst_Bufr = ByteBuffer.allocate(RQbuflen) ; 

  // ...