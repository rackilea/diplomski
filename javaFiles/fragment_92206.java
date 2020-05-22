@Id
@GeneratedValue
@Column(name = "OFR_ID", length = 11, nullable = false)
private Integer offerId;

@OneToOne(mappedBy = "offer", cascade = CascadeType.ALL)
private LikeDislike likeDislike;