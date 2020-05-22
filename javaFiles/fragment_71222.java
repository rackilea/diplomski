if (content.contains("png")){
    buffer.append("PNG");
}
if (content.contains("gif")){
    buffer.append("GIF");
}
if (content.contains("jpg")){
    buffer.append("JPG");
}
else {
    linklist.add(content + "\r\n");
}