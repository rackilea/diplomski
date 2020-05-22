/**
 * createMusicArray reads the stream and returns a list of short objects (the samples)
 */
public List<Short> createMusicArray (InputStream ins) throws IOException {
    List<Short> musicList = new ArrayList<Short>();

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    byte[] byteArray           = new byte[50*1024];
    int i = Integer.MAX_VALUE;
    while ((i = ins.read(byteArray, 0, byteArray.length)) > 0) {
        baos.write(byteArray, 0, i);
    }

    for (int j = 0; j < byteArray.length; j++) {
        short objShort = (short)(byteArray[j]); 
        musicList.add(objShort);
    }

    return musicList;
}