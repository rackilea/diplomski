public class Header{
     byte headerBytes;
     Header(byte[] hBytes){
          headerBytes = hBytes;
     }
     // here you implement getters/setters for your header 
     public String getFirstField(){
           byte[] field = new byte[20];// you can declare this as a class var it would be better
           for (int i = 0; i<20; i++)
                field[i] = this.headerBytes[i];   
           return new String(field/*,maybe put the encoding here */);
     }
     public Integer getAnIntField(pos start){// just a example how to get Integer 
           for (int i = start; i<4; i++)
                field[i] = this.headerBytes[i];
           return new Integer(ByteBuffer.wrap(bytes).getInt());   
     }

}