import static br.com.app.CustomerRepository.CustomerFetchingStrategy;

public class SomeController {

    // Again Spring Ioc or Seam @In-jection
    private CustomerRepository customerRepository;

    public void proccessForm(HttpServletRequest request, HttpServletResponse response) {
        request.setParameter("customer", customerRepository.getById(Integer.valueOf(request.getParameter("customerId"))), CUSTOMER);
    }
}