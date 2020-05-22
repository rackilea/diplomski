import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;

@Entity(name="CHILD")
public class CHILD {
    @Id
    private BigDecimal CHILD_ID;

    @OneToOne
    @JoinColumns({
        @JoinColumn(name = "PROD_GEN_ID", referencedColumnName = "PROD_GEN_ID"),
        @JoinColumn(name = "TAB_PROD_GEN_ID", referencedColumnName = "TAB_PROD_GEN_ID")
    })
    private TAB_PROD tab_prod;

    public BigDecimal getCHILD_ID() {
        return CHILD_ID;
    }

    public void setCHILD_ID(BigDecimal CHILD_ID) {
        this.CHILD_ID = CHILD_ID;
    }

    public TAB_PROD getTab_prod() {
        return tab_prod;
    }

    public void setTab_prod(TAB_PROD tab_prod) {
        this.tab_prod = tab_prod;
    }
}