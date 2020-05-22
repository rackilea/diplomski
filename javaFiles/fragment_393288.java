ZipEntry entry = new ZipEntry( fileName ); // You have to give each entry a different filename
zipOutputStream.putNextEntry( entry );
byte buffer[] = new byte[ 1024 ]; // 1024 is the buffer size here, but it could be anything really
int count;
while( (count = inputStream.read( buffer, 0, 1024 ) ) != -1 ) {
    zipOutputStream.write( buffer, 0, count );
}