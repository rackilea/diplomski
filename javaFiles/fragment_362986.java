public final String intercept(final ActionInvocation invocation) throws Exception {
   // before save original url
   Map session = invocation.getInvocationContext().getSession();
   Object action = invocation.getAction();
   if (!(action instanceof LoginAction)){ 
     String queryString = request.getQueryString();
     session.put("savedUrl", request.getRequestURI()+(queryString==null?"":("?"+queryString)));
   } else {
     return invocation.invoke();
   }

   if (!processLogin(request, session)) { //return false if not authenticated
     session.put("isLogin", true);
     return Action.LOGIN;
   } else {
       savedUrl = (String) session.get("savedUrl");
       boolean isLogin = (boolean)session.get("isLogin");
       if (!StringUtils.isEmpty(savedUrl) && isLogin) {
          session.put("isLogin", false); 
          return "redirect";
       }
       return invocation.invoke();
   }
}