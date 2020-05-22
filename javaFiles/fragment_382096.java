int offset = 0;
int read =  _fileStream.read(_contents, 0, contents.length);
while (read > 0) {
    offset += read;
    read = _fileStream.read(_contents, offset , contents.length - offset );

}