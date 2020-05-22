public interface Packet<T> {  
   T unpack(byte[] data);  
}  

public final class StringPacket implements Packet<String> {  
     public String unpack(byte[] data) {  
         // Implementation...  
     }  
}  

 // Similar classes for other types...