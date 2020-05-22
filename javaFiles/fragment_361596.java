@Entity
@Table(name = "candidate_jobReq")
public class ReqCandAssociation implements Serializable {

@Id
private Integer candidateId;

@Id
private Integer jobId;

@Column(name = "reqStatus")
private String reqStatus;

@OneToMany(cascade = { CascadeType.ALL }) //this is added here.
@JoinColumn(name ="reqCandAssociationId")
private Set<Comment> comments;
-----