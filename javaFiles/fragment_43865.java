public class RequestHolder {
   private @Autowired HttpServletRequest request;

   public String getServerName() {
      return request.getServerName();
   }
}