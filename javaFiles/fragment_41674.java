public final class TenOctaves {

    private static final int NUMBER_OF_NOTES = 120;

    private final Note[] notes = new Note[NUMBER_OF_NOTES];

    public void setNote(int position, Note note) {
         if (position < 0 || position >= NUMBER_OF_NOTES)
             throw new IllegalArgumentException();
         notes[position] = note;
    }

    public Note getNote(int position) {
        if (position < 0 || position >= NUMBER_OF_NOTES)
             throw new IllegalArgumentException();
        return notes[position];
    }
}