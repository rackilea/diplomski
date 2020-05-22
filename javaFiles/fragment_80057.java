public class Matches extends ForwardingList {
    private List<Match> matches;
    public Matches(List<Match> matches) { this.matches = matches; }
    public List<Match> delegate() { return matches; }
    // define your additional methods
}