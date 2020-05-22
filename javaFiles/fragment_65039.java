HttpSession session = req.getSession(false);

if (!session.isNew()) {
  if(ManageCustomerMbeans.AUTH_KEY!=null){
    chain.doFilter(req, resp);
  }
} else {
  //Session has expired - redirect to login.jsp
}