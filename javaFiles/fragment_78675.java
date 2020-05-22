@ManyToOne
@JoinColumn(name="Table2_id")
private Table2 Table2_id ;

@ManyToOne
@JoinColumn(name="Table2_Table1_username")
private Table2 Table2_Table1_username;