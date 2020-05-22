// ...
StringBuilder sb = new StringBuilder(); 
String line;
while ((line = inputStream.readLine()) != null) {
    sb.append(line);

    // if enough content is read, extract the chunk
    while (sb.length() >= chunkSize) {

        String c = sb.substring(0, chunkSize);
        // do something with the string

        // add the remaining content to the next chunk
        sb = new StringBuilder(sb.substring(chunkSize));
    }
}
// thats the last chunk
String c = sb.toString();
// do something with the string