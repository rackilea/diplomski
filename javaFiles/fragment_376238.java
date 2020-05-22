import java.nio.ByteBuffer;
    import java.nio.ByteOrder;

   public long ntohll(long convert)
    {
            ByteBuffer bbuf = ByteBuffer.allocate(8);  
            bbuf.order(ByteOrder.BIG_ENDIAN);  
            bbuf.putLong(convert);  
            bbuf.order(ByteOrder.LITTLE_ENDIAN);  
            return bbuf.getLong(0); 
    }