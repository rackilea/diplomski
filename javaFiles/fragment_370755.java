/**
 * 
 */
package hib;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 */
@Entity
@Table(name="STRATEGYALERT")
    @AssociationOverrides({ @AssociationOverride(name = "pk.strategy", joinColumns = @JoinColumn(name = "STRATEGYID")),
    @AssociationOverride(name = "pk.alert", joinColumns = @JoinColumn(name = "ALERTID")) })
public class StrategyAlert implements Serializable {

    @EmbeddedId
    private StrategyAlertPK pk = new StrategyAlertPK();

    @Column
    private String nominal;

    @Transient
    public Strategy getStrategy() {
        return pk.getStrategy();
    }

    public void setStrategy(Strategy strategy) {
        pk.setStrategy(strategy);
    }

    @Transient
    public Alert getAlert() {
        return pk.getAlert();
    }

    public void setAlert(Alert alert) {
        pk.setAlert(alert);
    }

    /**
     * @return the nominal
     */
    public String getNominal() {
        return nominal;
    }

    /**
     * @param nominal the nominal to set
     */
    public void setNominal(String nominal) {
        this.nominal = nominal;
    }
}