@GeneratedValue
@Column(name="LIKES_DISLIKES_ID", length = 11, nullable = false)
private Integer likeDislikeId;

@Expose
@OneToOne
@JoinColumn(name="OFR_ID", length = 11, nullable = false)
private Offer offer;