ByteArrayOutputStream stream = new ByteArrayOutputStream();
List<byte[]> imagesByteList = new List<byte[]>;
for(inputStream iStream: images){
    stream.write(IOUtils.toByteArray(iStream);     
    imagesByteList.add(stream.toByteArray());
    stream.reset();
}
return imagesByteList; // here you get all your image in bytes array form