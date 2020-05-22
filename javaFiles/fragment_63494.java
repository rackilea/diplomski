You need create a sequence and follow this way

/**
 * The persistent class for the TB_FINALIDADE_PORTARIA database table.
 * 
 */
@Entity
@Table(name="TB_FINALIDADE_PORTARIA")
public class FinalidadePortaria implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="FINALIDADE_PORTARIA_ID_GENERATOR", sequenceName="SQ_FINALIDADE_PORTARIA")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FINALIDADE_PORTARIA_ID_GENERATOR")
    @Column(name="ID_FINALIDADE_PORTARIA")
    private Long id;