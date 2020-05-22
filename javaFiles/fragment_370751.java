@Entity
@Table(name="STRATEGYALERT")
@IdClass(StrategyAlertPK.class)
public class StrategyAlert implements Serializable {
   @Id
   @ManyToOne
   @JoinColumn(name="STRATEGYID", insertable=false, updatable=false)
   private Strategy strategy;

   @Id
   @ManyToOne
   @JoinColumn(name="ALERTID", insertable=false, updatable=false)
   private Alert alert;

   @Column
   private String nominal;

   // TODO Getters and setters
}