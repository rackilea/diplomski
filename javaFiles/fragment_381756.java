@RestController
public class ApiWebService {

       @Autowired
       private ServiceFactory serviceFactory;

       @GetMapping("insert/order")
       public void test() {
            Integer companyId = getCompanyIdFromToken(httpServletRequest); 
            BaseService service = serviceFactory.getService(companyId);
            service.blablabla();
       }

}