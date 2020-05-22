package stack;

public class ServiceInit
{

   public static void main(String[] args)
   {
       new ServiceInit();
   }

   public ServiceInit()
   {
       ServiceBeanInterface xbean = ServiceFactory.getInstance().getServiceBean("X");

       xbean.callService();

       ServiceBeanInterface ybean = ServiceFactory.getInstance().getServiceBean("Y");

       ybean.callService();
   }
}