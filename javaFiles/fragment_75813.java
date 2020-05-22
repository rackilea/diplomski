@RequestMapping( value = "/invalidate.do", method = RequestMethod.GET )
    public String invalidate(HttpServletRequest request)
    {
       request.setAttribute("invalidate",true);
       return "login";
    }