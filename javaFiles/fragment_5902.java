public class UriFlowUrlHandler extends DefaultFlowUrlHandler
{
   @Override
   public String getFlowId(HttpServletRequest request)
   {
      // Strip off leading "/" and any file extension (e.g., ".jsp")
      String uriNoExtension = StringUtils.substringBeforeLast(request.getRequestURI().substring(1), ".");

      if (StringUtils.isNotEmpty(uriNoExtension))
         return uriNoExtension;
      else
         return super.getFlowId(request);
   }
}