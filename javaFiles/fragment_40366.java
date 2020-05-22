if(session.getAttribute(firstLoginFlag) == null){
    //load UserBean
    //do whatever else
    session.setAttribute(firstLoginFlag, true);
}
chain.doFilter(request, response);