@XmlElement(name="userSurvey")
@ManyToOne(optional=false)
@JoinColumn(name="`userSurveyId`",unique=true)
private UserSurvey userSurvey;

@XmlElement(name="supervisorSurvey")
@ManyToOne(optional=false)
@JoinColumn(name="`supervisorSurveyId`",unique=true)
private SupervisorSurvey supervisorSurvey;