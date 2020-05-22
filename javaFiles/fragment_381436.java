while ((byteRead = readableByteChannel.read(buffer)) > 0 && readCount < 68) {
    sb.append(new String(buffer.array(),
        buffer.arrayOffset(), buffer.arrayOffset()+buffer.position(), "UTF-8"));
    buffer.clear();
    readCount++;
}