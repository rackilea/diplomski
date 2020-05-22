OutputStream outputStream = response.getOutputStream();

while ((readBytes = fileToDownload.read(buffer)) != -1) {
    outputStream.write(buffer,0,readBytes);
}

outputStream.close();