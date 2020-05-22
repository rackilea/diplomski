@Entity
@Table(name="table1")
@SecondaryTable(name="table2")
    public class Table1{

    //by default these are mapped to T1
    @Id
    private String id;
    private String record;
    private Date date;
    private String name ;

    //explicitly specify the table to map to T2
    @Column(table="table2")
    private String city:

}