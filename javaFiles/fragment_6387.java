@RooJavaBean
@RooToString
@RooJpaEntity(entityName = "AUX_CLIENTES")
public class AuxCliente {


    @Transient
    @Autowired
    private SaldoClienteService saldoClienteService;

    @PostPersist
    void afectaSaldoCliente() {
       this.saldoClienteService.doWhatYouWant();
    }

}