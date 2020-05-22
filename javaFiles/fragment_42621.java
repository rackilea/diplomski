// On Voter side
@OneToOne(cascade=CascadeType.ALL)
private Votes votes;

// On Votes side
@OneToOne(cascade=CascadeType.ALL)
private Voter voter;