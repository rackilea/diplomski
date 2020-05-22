@Entity
@Table(name = "OECATPAG")
public class OfferWeeks implements Serializable{
    String week;
    BigDecimal sales;

    @Id
    @Column(name = "FCLYERWK", columnDefinition = "varchar2(40)")
    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    @Column(name = "RMSALES", columnDefinition = "decimal(18,9)")
    public BigDecimal getSales() {
        return sales;
    }

    public void setSales(BigDecimal sales) {
        this.sales = sales;
    }

}