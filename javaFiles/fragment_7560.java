class BusinessServiceImpl implements BusinessService {

    BusinessServiceImpl() {
        // constructor logic
    }
}

// should be in the same package as BusinessServiceImpl
public final class BusinessServiceFactory {

    private BusinessServiceImpl instance;

    public BusinessService getInstance() {
        // instance creation logic, same as singleton creation logic
    }

}