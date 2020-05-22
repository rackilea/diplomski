public class Programme {
    private String type;
    private String pid;
    private String position;
    private String title;
    private String short_synopsis;
    private String media_type;
    private int duration;
    private String first_broadcast_date;
    private DisplayTitle display_titles;
    private Ownership ownership;
    private Programme programme;

    // TODO: create other getters & setters if you need
    public String getShort_synopsis() {
        return short_synopsis;
    }

    public DisplayTitle getDisplay_titles() {
        return display_titles;
    }
}