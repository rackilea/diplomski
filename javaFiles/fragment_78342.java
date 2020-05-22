@Entity
 @Table(name = "payment_transactions")
 public class PaymentTransactions implements Serializable {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name = "id", unique = true, updatable = false, nullable = false)
 private int id;

 @OneToOne(mappedBy="paymentTransactions") //or OneToMany depending on your model
 private WpfPaymentPaymentTransactions wpfPaymentPaymentTransactions;

 }


 @Entity
 @Table(name = "wpf_payment_payment_transactions")
 public class WpfPaymentPaymentTransactions implements Serializable {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name = "id", unique = true, updatable = false, nullable = false, length = 3)
 private int id;

 @ManyToOne
 @JoinColumn(name="wpf_payment_id")
 private PaymentTransactions paymentTransactions;
 }