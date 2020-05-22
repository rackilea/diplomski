//somthing like this
class CarSvcProxy implement DAOService {

    public Object getOrder(Long id) {

        try {

            // ...

            txManager.commit();

        } catch (Exception ex) {
            txManager.rollback();
        }
    }
}

@RestController
public class OrderController {

    //So when you do this :
    @Autowired
    CarSvc carSvc;

    //it's somehow like if you did : 
    CarSvc carSvc = new CarSvcProxy(); //carSvc != CarSvcProxy

    //But this will work :
    DAOService carSvc = new CarSvcProxy(); //because CarSvcProxy implement DAOService

}