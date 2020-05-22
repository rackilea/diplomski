// Create a buffer for the data generated:
ByteArrayOutputStream bos = new ByteArrayOutputStream();

ObjectOutputStream out=new ObjectOutputStream( bos );

out.writeObject(ss3);

// This makes sure the stream is written completely ('flushed'):
out.close();

// Retrieve the raw data written through the ObjectOutputStream:
byte[] data = bos.toByteArray();

// Wrap the raw data in an ObjectInputStream to read from:
ByteArrayInputStream bis = new ByteArrayInputStream( data );
ObjectInputStream in = new ObjectInputStream( bis );

// Read object(s) re-created from the raw data:
SomeClass obj = (SomeClass) in.readObject();

assert obj.equals( ss3 ); // optional ;-)