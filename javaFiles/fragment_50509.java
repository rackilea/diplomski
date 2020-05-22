@RequestMapping(value = "/admin/listembassy", method = RequestMethod.GET)
public @ResponseBody void listEmbassyByCountryCode(HttpServletRequest req,HttpServletResponse resp, ModelMap modelMap) throws JSONException, JsonGenerationException, JsonMappingException, IOException {
    String countryCode = req.getParameter("searchForCountryCode");
    String destinationCountryStartLetter = req.getParameter("destinationCountryStartLetter");
    EmbassyDao embassyDao = (EmbassyDao) context.getBean("embassyDao");
    JSONArray jsonArray = new JSONArray();
    if(destinationCountryStartLetter != null && !destinationCountryStartLetter.equals("")){
        jsonArray = embassyDao.getObjectsJsonArrayByCountryCodeAndDestination(countryCode, destinationCountryStartLetter);
    }else{
        jsonArray = embassyDao.getObjectsJsonArrayByCountryCode(countryCode);
    }
    resp.setContentType("application/json");
    resp.setCharacterEncoding("UTF-8");
    resp.getWriter().println(jsonArray);
}