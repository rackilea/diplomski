@Id
@Basic(optional = false)
@GeneratedValue(strategy=GenerationType.IDENTITY, generator="IdOrGenerated")
@GenericGenerator(name="IdOrGenerated",strategy="....UseIdOrGenerate")
@Column(name = "ID", unique = true, nullable = false, precision = 20, scale = 0)
public Long getId(){..}