String ImportTextFile()
{
    String myText = "";
    try {
    InputStream fileStream = getResources().openRawResource(
                        R.raw.legal);
    int fileLen = fileStream.available();
    // Read the entire resource into a local byte buffer.
    byte[] fileBuffer = new byte[fileLen];
    fileStream.read(fileBuffer);
    fileStream.close();
    displayText = new String(fileBuffer);
    } catch (IOException e) {
      // exception handling
    }
    return myText;
}