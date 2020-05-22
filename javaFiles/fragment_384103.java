@RequestMapping(value = "/start.htm")
    public String start(HttpServletRequest request, Model model)
            throws Exception 
{

// do something
// storing uniqueId
request.getSession().setAttribute("uniqueId",uniqueId) ;
request.getSession().setAttribute(uniqueId,bytesOfaPDF);

return "jspname";
}