@Entity
public class Company {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fkIdCompanyEstimateOption")
    private EstimateOptions estimateOptions = new EstimateOptions();

    @OneToOne(mappedBy="company", fetch = FetchType.LAZY)
    private User user; 

}