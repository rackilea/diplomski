...
import javax.validation.constraints.NotNull;
....

@ManyToOne(optional=false)
@JoinColumn(name="TERM_ID", nullable=false)
@NotNull
private Term term;