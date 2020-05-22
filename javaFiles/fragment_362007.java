if (objSource instanceof Sequence) {
    Sequence sequence = (Sequence) objSource;
    int[] types = MidiSystem.getMidiFileTypes(sequence);

    MidiSystem.write(sequence, types[0], bos);

    byte[] byteData = bos.toByteArray();
    ByteArrayInputStream bais = new ByteArrayInputStream(byteData);

    try {
        return MidiSystem.getSequence(bais);
    } catch (InvalidMidiDataException e) {
        throw new IOException(e);
    }
}