ByteArrayOutputStream bos = new ByteArrayOutputStream() ;
ObjectOutput out  = new ObjectOutputStream(bos) ;
out.writeObject(object);
out.close();

byte[] dataArray = bos.toByteArray();