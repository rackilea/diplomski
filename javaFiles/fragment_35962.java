package hello;

    import javax.transaction.Transactional;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    @Service
    public class CustomerService {
        @Autowired
        private CustomerRepository customerRepository;

        @Transactional
        public void store(){
            Address address1 = new Address("07093", "Brooklyn", "129 67th st", null, "USA");
            Address address2 = new Address("03333", "Qeeens", "333 67th st", null, "USA");
            // save a couple of customers
            Customer jack = new Customer("Jack", "Bauer");

            jack.setHomeAddress(address1);

            customerRepository.save(jack);                  
            customerRepository.save(new Customer("Chloe", "O'Brian", address1));
        }
    }