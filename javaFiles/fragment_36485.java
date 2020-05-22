@Stateless
@Local(CustomerControllerLocal.class)  //I should put EmployeeControllerLocal
@Remote(Customer ControllerRemote.class) //Same goes for here, remote.

public class EmployeeController implements EmployeeControllerRemote, EmployeeControllerLocal {
 //ommited the rest
}