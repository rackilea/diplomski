For OpinionPoll:

// mappedBy "opinionPoll" --> the OpinionPoll object in Result class
@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL,mappedBy="opinionPoll")
private List<PollResult> pollResults = new ArrayList<PollResult>() ;


For Result :

@ManyToOne
@JoinColumn(name = "pid")
private OpinionPoll opinionPoll;