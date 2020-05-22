byte[] bytes ...;
ByteBuffer buffer = ByteBuffer.wrap(bytes); // No copy, changes are reflected

int foo = buffer.getInt(0); // get int value from buffer

foo *= 2; 
buffer.putInt(0, foo); // write int value to buffer

// Or perhaps 
IntBuffer intBuffer = buffer.asIntBuffer(); // Creates an int "view" (no copy)
int bar = intBuffer.get(0);
intBuffer.set(0, bar);