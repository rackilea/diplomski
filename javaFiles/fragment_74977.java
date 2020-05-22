public class MyTable
{
    @Id
    @SequenceGenerator(name="seq",sequenceName="oracle_seq")        
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")               
    private Integer pid;
}