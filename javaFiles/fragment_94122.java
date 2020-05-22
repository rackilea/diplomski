@Service
public class CowService {

   FooService fooService;

   //FooService will be injected when CowService bean is constructed
   public(FooService fooService) {
     this.fooService = fooService;
   }
}