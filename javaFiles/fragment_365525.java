private Form<Product> productForm;

@Inject
public ProductsController(FormFactory formFactory) {
    this.productForm = formFactory.form(Product.class);
}