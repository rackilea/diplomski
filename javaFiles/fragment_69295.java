@Mapper
public interface CustomerProfileMapper {
    CustomerProfile toCustomerProfile(CustomerProfileDO profileDO) ;  
    Customer   toCustomer(CustomerDO customerDO);
    Identifier toIdentifier(CustomerIdentifierDO identifierDO);


    default void afterMapping(@MappingTarget CustomerProfile profile, CustomerProfieDO profileDO) {
        Identifier identifier = profile.getCustomer().getIdentifier();
        identifier.setStatus(profileDO.setStatus());
        identifier.setType(profileDO.setCategory());
    }    
}