@Column(name = "page_id")
private Integer pageId;

@Column(name = "xml_id")
private Integer xmlId;

@ManyToOne
@JoinColumn(name = "set_id")
private CustomSet set;