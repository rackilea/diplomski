@Entity
public class SurveyForm {
    @OneToMany
    @MapKeyJoinColumn(name = "question")
    @JoinTable(joinColumns = @JoinColumn(name="answer"))
    public Map<SurveyFormQuestion, SurveyFormAnswer> questionAndAnswer;
}