byte[] nameBuffer = new byte[lengthName];
if(ds.read(nameBuffer) != lengthName) {
    // error handling here
    return;
}
imgName = new String(nameBuffer, "ISO-8859-1");