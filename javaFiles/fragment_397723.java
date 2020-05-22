@Service
@Qualifier("customerBaseService") 
public class CustomerBaseService extends BaseService<Customer, Long> {
    public CustomerBaseService (CustomerRepository repository){
      super(repository);
    }
}

@Service
@Qualifier("merchantBaseService") 
public class MerchantBaseService extends BaseService<Merchant, Long> {
    public MerchantBaseService (MerchantRepository repository){
      super(repository);
    }
}