public class Score{

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "type")
    @Enumerated(EnumType.String)//or ordinal
    private ScoreType type;
}