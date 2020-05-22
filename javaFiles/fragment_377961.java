private boolean Seek() throws IOException {
    while(!(CheckHeader() && SkipAudioData())){
        if(!ShiftHeader()){
            return false;
        }
    }
    return true;
}


private boolean ShiftHeader() {
    try {
        if (bytesRead >= MPEG_FILE.length()) {
            return false;
        }
    } catch (Exception ex) {
        ex.printStackTrace();
        return false;
    }

    header[0] = header[1];
    header[1] = header[2];
    header[2] = header[3];

    try {
        int b = fis.read();
        if (b > -1) {
            header[3] = b;
            return true;
        }
    } catch (IOException ex) {
        return false;
    } catch (Exception ex) {
        return false;
    }

    return false;
}