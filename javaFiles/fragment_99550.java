public class Genre {
    // ...
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="genre")
    private Movie movie;
}