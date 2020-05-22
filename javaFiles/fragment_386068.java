public class Note extends Comparable<Note> {

    private NoteManager noteManager:
    private final String content; // Immutable.

    public NoteManager(NoteManager noteManager, String content) {
        this.noteManager = noteManager;
        this.content = content;
    }
    ... compare on the immutable content
    ... hashCode on content