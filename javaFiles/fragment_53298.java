@ManagedBean
@ViewScoped
public class CepMB {
    Cep cep;
    @PostConstruct
    public void init() {
        cep = new Cep();
    }
    //rest of your getters, setters, code...
}