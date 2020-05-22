public class AddressDaoImpl extends GenericDaoImpl<Address> {
    @Override
    public String getTableName() {
        return "Address";
    }
}