public class CustomWrapper extends HttpServletRequestWrapper
{

    public CustomWrapper(HttpServletRequest request) {
        super(request);

    }

   public boolean isSecure()
   {
        return true;
   }

    public String getScheme()
   {
       return "https";
   }
}