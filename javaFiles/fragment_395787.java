/**
 * createMusicArray reads the stream and returns a list of short objects (the samples)
 */
public List<Short> createMusicArray (InputStream ins) throws IOException {
    LittleEndianDataInputStream dis = new LittleEndianDataInputStream(ins);

    while (true) {
        try {
            short d = dis.readShort();
            musicList.add(d);
        } catch( EOFException e ) {
            break;
        }
    }

    return musicList;
}