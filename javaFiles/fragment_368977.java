@Entity
         @Table(name="invoice")
         public class Invoice {

        @Id
        @Column(name="Id")
        private int Id;

        @Column(name="WeightQty")
        private String WeightQty;

        @Column(name="Details")
        private String Details;

        @Column(name="Rate")
        private int Rate;

        @Column(name="Debit")
        private int Debit;

        @Column(name="Credit")
        private int Credit;

       @ManyToOne
    @JoinColumn(name = "customerid")
private Customer customer;

@ManyToOne
    @JoinColumn(name = "containerid")
private Container container;


        public Invoice(){

        }