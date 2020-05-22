@Mapper(componentModel = "spring", uses = { MapperUtils.class })
public interface CustomerTagApiMapper {

    CustomerTagAPI toCustomerTagApi(CustomerTag customerTag);

}

@Mapper(componentModel = "spring", uses = {  CustomerTagApiMapper.class, MapperUtils.class })
public interface CustomerApiMapper {

    CustomerAPI toCustomerApi(Customer customer);

}