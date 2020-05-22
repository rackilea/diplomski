AudioFile f = AudioFileIO.read(wavFile);
WavTag tag = (WavTag) f.getTag();

Object[] temp = {false,
        tag.getFirst(FieldKey.TITLE),
        tag.getFirst(FieldKey.ARTIST),
        f.getAudioHeader().getTrackLength() // In seconds
};