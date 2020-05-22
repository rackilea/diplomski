ByteArrayOutputStream baos = new ByteArrayOutputStream(20);
DataOutputStream dos = new DataOutputStream( ... );
dos.writeFloat( altitude );
dos.writeFloat( max_temperature );
dos.writeFloat( longitude );
dos.writeFloat( latitude );
dos.writeFloat( average_acceleration);
byte[] data = baos.toByteArray();