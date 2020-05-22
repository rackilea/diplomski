interface IOracleFactoryDao{
     void myOracleMethod();
 }
 interface IDB2FactoryDao{
     void myDB2Method();
 }
 public class OracleFactoryDao extends DAOFactory implements IOracleFactoryDao {
     void myOracleMethod(){...}
}
public class DB2FactoryDao extends DAOFactory implements IDB2FactoryDao{
     void myDB2Method(){...}
}