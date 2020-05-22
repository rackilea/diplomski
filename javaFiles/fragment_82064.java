@WebService(endpointInterface = "com.example.AddressService" )
public class AddressServiceImpl implements AddressService {

@Override
public Address validateAdress(Address address) {
     return  address;
    }

    @Override
    public String sayHi(String msg) {
        return "Vinay";
    }
}