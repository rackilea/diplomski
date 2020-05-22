ByteArrayOutputStream baos = new ByteArrayOutputStream();
int reads = is.read();

while(reads != -1){
    baos.write(reads);
    reads = is.read();
}

byte[] data = baos.toByteArray();