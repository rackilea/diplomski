@Tag("customers-view")
@HtmlImport("src/views/customers/customers-view.html")
@Route(value = ApplicationConst.PAGE_CUSTOMERS, layout = MainView.class)
@PageTitle(ApplicationConst.TITLE_CUSTOMERS)
public class CustomersView extends PolymerTemplate<TemplateModel> {

CustomerRepository customerRepository;

@Autowired
public CustomersView(CustomerRepository customerRepository) {
    this.costumerRepository = customerRepository;
    this.customerRepository.findAll();
}

}