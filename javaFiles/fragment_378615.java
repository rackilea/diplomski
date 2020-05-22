@ManagedBean
@ViewScoped
public class Bean {

    private boolean showDisabledProducts;
    private List<Product> enabledProducts;
    private List<Product> disabledProducts;

    @EJB
    private ProductService service;

    @PostConstruct
    public void init() {
        enabledProducts = service.listEnabledProducts();
        disabledProducts = service.listDisabledProducts();
    }

    public void toggle() {
        showDisabledProducts = !showDisabledProducts;
    }

    public List<Product> getProducts() {
        return showDisabledProducts ? disabledProducts : enabledProducts;
    }

    public boolean isShowDisabledProducts() {
        return showDisabledProducts;
    }

}