/**
 * 
 */
package hib;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 *
 */
@Embeddable
public class StrategyAlertPK implements Serializable {

    @ManyToOne
    private Strategy strategy;

    @ManyToOne
    private Alert alert;
    /**
     * @return the strategy
     */
    public Strategy getStrategy() {
        return strategy;
    }
    /**
     * @param strategy the strategy to set
     */
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
    /**
     * @return the alert
     */
    public Alert getAlert() {
        return alert;
    }
    /**
     * @param alert the alert to set
     */
    public void setAlert(Alert alert) {
        this.alert = alert;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        StrategyAlertPK that = (StrategyAlertPK) o;

        if (strategy != null ? !strategy.equals(that.strategy) : that.strategy != null) {
            return false;
        }
        if (alert != null ? !alert.equals(that.alert) : that.alert != null) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int result;
        result = (strategy != null ? strategy.hashCode() : 0);
        result = 31 * result + (alert != null ? alert.hashCode() : 0);
        return result;
    }


}