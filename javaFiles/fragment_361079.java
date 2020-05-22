// pure business logic method here no dependency on servlets or any network protocol just pojos in
// pojos out 
@Service
public interface PhotoServices {
   public void doSomething(....)

}

/**
* Restful interface knows about Sevlets request and response http status codes ... etc\
* does web stuff and delegates to the PhotoService
*/
@Controller
public class PhotoWebController {

 @Autowired
 private PhotoService photoSerivce;

  @RequestMapping .... 
  public void doSemething(....)
  {
        this.photoSerivce.doSomething(....)
  }
}




/**
* RPC end point understand how to handle error conditions with Hessian ... etc
* 
*/
 // put whatever annoations you need to put for hessian 
public class PhotoHessianController {

 @Autowired
 private PhotoService photoSerivce;

  // hessian annotations go here
  public void doSemething(....)
  {
        this.photoSerivce.doSomething(....)
  }
}