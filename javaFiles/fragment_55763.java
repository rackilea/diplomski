public class User{  

    @Column(name="userName", unique=true)
    private String username;

    @Column(name="password")
    private String password;

    @OneToMany
    @MapKeyColumn(name="score_type")
    @MapKeyEnumerated
    private Map<ScoreType, Score> scores; 

    public Score getHighScore(){
        return scores.get(ScoreType.HIGH);
    }

    public void setScore(Score score){
        score.setUser(this);
        scores.put(score.getType(), score);
    }
}