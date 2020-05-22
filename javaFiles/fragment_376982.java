public class EventComparator implements Comparator<Event> {

    private String tagName;

    public EventComparator(String tagName) {
        this.tagName = tagName;
    }

    @Override
    public int compare(Event e1, Event e2) {
        Tag t1 = getTag(e1, tagName); // getTag(...) returns the e1's tag with name 'tagName'
        Tag t2 = getTag(e2, tagName);

        // Ignoring null check for brevity
        if (t1.getRank() > t2.getRank())
            return 1;
        else if (t1.getRank() < t2.getRank())
            return -1;
        else
            return 0;
    }
}