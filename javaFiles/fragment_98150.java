@RequestMapping(value={"/news"},method={org.springframework.web.bind.annotation.RequestMethod.POST,
            org.springframework.web.bind.annotation.RequestMethod.GET})
    public String getQueryParams(final Model model,final HttpServletRequest request){
String startDate= request.getParameter("startDate");
String author= request.getParameter("author");
}