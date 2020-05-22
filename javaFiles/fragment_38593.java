public class SectionNotFoundException extends Throwable {
    List<Journal> journalList;

    public SectionNotFoundException(List<Journal> journalList) {
         this.journalList = journalList == null ? new ArrayList<>() : journalList; 
    }
}