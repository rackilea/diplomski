public class MyClient {
 //InStreams
 protected DataInputStream mInStream;

 public int read(byte[] buffer)
 {
       MyClass obj1 =  new MyClass();
       mInStream = new DataInputStream(obj1.getInputStream());
       try
       {
           int i = mInStream.read(buffer);
           return i;
       }
       catch (IOException ex)
       {
           return -1;
       }
 }

 public static void main(String args[])
 {
    MyClient cl1 = new MyClient();
    int ret = 0;
    byte[] data = {};

    ret = cl1.read(data);

 } 
}