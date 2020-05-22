public class SectionNotFoundException extends Throwable {
    List<Journal> journalList;

    public SectionNotFoundException(List<Journal> journalList) {
        if(journalList == null) {
            this.journalList = new ArrayList<>();
        } else {
            this.journalList = journalList;
        }
    }
}