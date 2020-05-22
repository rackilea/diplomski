import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="TAB_PROD")
public class TAB_PROD implements Serializable {
    @Id
    private BigDecimal TAB_PROD_ID;

    @Column (name = "PROD_GEN_ID", unique = true)
    private BigDecimal PROD_GEN_ID;

    @Column (name = "TAB_PROD_GEN_ID", unique = true)
    private BigDecimal TAB_PROD_GEN_ID;

    public BigDecimal getTAB_PROD_ID() {
        return TAB_PROD_ID;
    }

    public void setTAB_PROD_ID(BigDecimal TAB_PROD_ID) {
        this.TAB_PROD_ID = TAB_PROD_ID;
    }

    public BigDecimal getPROD_GEN_ID() {
        return PROD_GEN_ID;
    }

    public void setPROD_GEN_ID(BigDecimal PROD_GEN_ID) {
        this.PROD_GEN_ID = PROD_GEN_ID;
    }

    public BigDecimal getTAB_PROD_GEN_ID() {
        return TAB_PROD_GEN_ID;
    }

    public void setTAB_PROD_GEN_ID(BigDecimal TAB_PROD_GEN_ID) {
        this.TAB_PROD_GEN_ID = TAB_PROD_GEN_ID;
    }
}