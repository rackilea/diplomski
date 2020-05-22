public abstract class DAOFactory<DAO extends BaseDAO> {
public DAO getCustomerDAO();
public static <DAO extends BaseDAO> DAOFactory<DAO> getInstance(Class<DAO> typeToken){
  // instantiate the the proper factory by using the typeToken.
  if(system.getProperty("allowtest").equals("yes")) {
  return new TestDAOFactory();
  }
  else return new ProdDAOFactory();
}