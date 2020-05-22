@TableGenerator(name = "entities_id_generator", table = "SEQUENCE",                
pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT", pkColumnValue = 
"ENTITY_SEQ", initialValue = 0, allocationSize = 1)
public class DBObject1 implements Serializable {
@Id
@GeneratedValue(generator = "entities_id_generator", strategy = GenerationType.TABLE)
private Long id;
@ManyToOne
@JoinColumn(name = "source_id")
private DBObject2 source;
}

@TableGenerator(name = "entities_id_generator", table = "SEQUENCE",                 
pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT", pkColumnValue = 
"ENTITY_SEQ", initialValue = 0, allocationSize = 1)
public class DBObject2 implements Serializable {
@Id
@GeneratedValue(generator = "entities_id_generator", strategy = GenerationType.TABLE)
private Long id;
@OneToMany(cascade = CascadeType.ALL, mappedBy = "source")
private List<DBObject1> objects;
}