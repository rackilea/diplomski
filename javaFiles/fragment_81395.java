@Override
public void postHandle(HttpServletRequest request,
                       HttpServletResponse response, Object handler,
                       ModelAndView modelAndView) throws Exception { 
    HttpSession session = request.getSession(); 
    try{
        if(session != null){                            //Infinite 
            response.sendRedirect("register");
            return;
        }
    }catch(Exception e){
        e.toString();
    }

}