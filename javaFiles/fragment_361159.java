@RequestMapping("/test")
public ModelAndView eGiftActivation(HttpServletRequest request) {

    Map<String, String[]> params = request.getParameterMap();
    if (params.size() != 1 || !params.containsKey("value")) {
        throw new RuntimeException("Extra parameters are present"); // or do redirect
    }
    ...
}