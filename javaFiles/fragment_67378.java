@Entity
@Table(name = "financial_aid_request_table")
public class FinancialAidRequestEntity extends BaseAuditingEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy= "financialAidRequest")
    private List<FARWorkFlowHistoryEntity> farWorkFlowHistory;
@ManyToOne(fetch = FetchType.LAZY)
    @JoinFormula("(" +
        "SELECT h.far_workflow_history_id " +
        "FROM tten_farservice_far_workflow_history_table h " +
        "WHERE h.financial_aid_request_id = id " +
        "ORDER BY h.updated_date DESC " +
        "LIMIT 1" +
    ")")
    private FARWorkFlowHistoryEntity latestHistory;

}