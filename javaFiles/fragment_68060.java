@ElementCollection
@CollectionTable(name= "keyword_to_related_keyword")
@Column(name="ratio")
@MapKeyColumn(name="related_keyword_id")
@MapKeyJoinColumn(name="some_other_preferred_name")
public Map<Keyword, Integer> keywordRelated;