@Configuration
public class ServiceFactory{

   @Bean
   public  BaseService companyOneService(){
     return new CompanyOneService();
   }

   @Bean
   public  BaseService companyTwoService(){
     return new CompanyTwoService();
   }

   public BaseService getService(Integer companyId){
        if(companyId == 1){
            return companyOneService();
        }else if(company==2){
            return companyTwoService();
        }else{
            //blablablab
        }
   }
}