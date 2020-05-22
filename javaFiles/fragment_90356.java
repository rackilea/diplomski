@Id
 @GeneratedValue(strategy=SEQUENCE, generator="CUST_SEQ")
 @Column(name="CUST_ID")
 public Long getId() { return id; }

 Example 2:

 @Id
 @GeneratedValue(strategy=TABLE, generator="CUST_GEN")
 @Column(name="CUST_ID")
 Long id;