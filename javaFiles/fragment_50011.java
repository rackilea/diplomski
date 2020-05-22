@Entity
public class Actor {

    private List<Credits> credits = new ArrayList<Credits>();

    @OneToMany
    @JoinColumn(name="ACTOR_ID")
    public List<Credits> getCredits() {
        return this.credits;
    }

    @Transient
    public List<Credits> getCreditsOrderedByMovieYear() {
        Collections.sort(credits, new Comparator<Credits>() {
            public int compare(Credits o1, Credits o2) {
                // Integer implements Comparable<T>
                return o1.getMovie().getYear().compareTo(o2.getMovie().getYear());
            }
        });

        return credits;
    }

}