public class Note {

    private long key;
    private String note;


    public Note(String note) {
        this.note = note;
        this.key = System.currentTimeMillis();
    }

    public Note(long key, String note) {
        this.key = key;
        this.note = note;
    }

    public Note(String key, String note) {
        this.key = Long.parseLong(key);
        this.note = note;
    }

    public long getKey() {
        return key;
    }

    public String getNote() {
        return note;
    }

    public String getKeyAsString(){
        return String.valueOf(key);
    }
}