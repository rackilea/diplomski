@ExceptionHandler(HttpSessionRequiredException.class)
public String (HttpServletRequest request) {
    String referrer = request.getHeader("referer");
    ...
    FlashMap flashMap = RequestContextUtils.getOutputFlashMap(request);
flashMap.put("errorMessage","Execute A Query Then Retry");
    return "redirect:/my/url";
}