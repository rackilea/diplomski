@Entity
public class Assessment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String assessmentId;

    private String assessmentTopic;

    private String assessmentSubTopic;

    private String assessmentLevel;

    private String createdBy;

    private String rating;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "assessment", fetch = FetchType.LAZY)
    private List<Question> questionList;

    // ...
}

@Entity
public class Question implements Serializable {

    @EmbeddedId
    private QuestionAssessmentKey questionAssessmentKey;

    @ManyToOne
    @MapsId("assessmentId") // maps assessmentId attribute of embedded id
    private Assessment assessment;

    private QuestionTypes questionType;

    private String questionText;

    private String questionURL;

    private QuestionStatus questionStatus;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "questionNumber", referencedColumnName = "questionNumber")
    private List<QuestionOption> questionOptions;

    // ...
}

@Entity
public class QuestionMetaData {

    @EmbeddedId
    private QuestionAssessmentKey questionAssessmentKey;

    private String topicName;

    private String subtopicName;

    private QuestionComplexity complexity;

    private String conceptName;

    @ManyToOne
    @MapsId("assessmentId") // maps assessmentId attribute of embedded id
    private Assessment assessment;

    // ...
}

@Entity
public class AnswerKey {

    @EmbeddedId
    private QuestionAssessmentKey questionAssessmentKey;

    private Character answer;

    @ManyToOne
    @MapsId("assessmentId") // maps assessmentId attribute of embedded id
    private Assessment assessment;

    // ...
}

@Embeddable
public class QuestionAssessmentKey implements Serializable {

    private String assessmentId;

    private int questionNumber;

    // ...
}