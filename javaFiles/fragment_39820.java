@Entity
@Table(name = "venda_credito")
public class VendaCredito {

    private long cod;
    private Venda venda;
    private Cliente cliente;
    private StatusPagamento statusPagamento;
    private Date dataPagamento;

    @Id
    public long getCod() {
        return cod;
    }

    @MapsId
    @JoinColumn(name = "ven_cod")
    @OneToOne
    public long getCod() {
        return cod;
    }
    .
    .
    .