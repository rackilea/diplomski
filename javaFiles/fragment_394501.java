private static ID3v1 get_tag(Music msc) {
    try {
        Mp3File file = new Mp3File(msc.get_path());

        if (file.hasId3v1Tag()) {
            return file.getId3v1Tag();
        } else if (file.hasId3v2Tag()) {
            return file.getId3v2Tag();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}