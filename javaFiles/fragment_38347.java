@RequestMapping(value = "/getNewService", method = RequestMethod.POST)
public ModelAndView getNewServicePost() {
    StringWriter writer = new StringWriter();
    try {
        IOUtils.copy(request.getInputStream(), writer, "UTF-8");
    } catch (Exception e) {
        e.printStackTrace();
    }
    String theString = writer.toString();
    int pNum = XMLUtil.extractNum(theString);
    List<Object> results = XMLDaoLayer.getResults(pNum);
    String message = XMLUtil.convertListToResponse(results);
    return new ModelAndView("response","message",message);
}