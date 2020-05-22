@Entity
@Table(name = "tabelName")
public class yourEntity{
    @Id
    @SequenceGenerator(name = "yourName", sequenceName = "yourSeqName", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "yourName")
    @Column(name = "id", updatable = false)
    protected Long id;
}

@Query(value = "SELECT yourSeqName.nextval FROM tableName", nativeQuery = true)
Long getNextSeriesId();