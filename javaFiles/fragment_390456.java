@RequestMapping(produces = "application/json")
@ResponseBody
public AjaxResponse ajax(HttpServletRequest request, AjaxRequest ajaxRequest) {
    ajaxRequest.bind(request);
    // ...
}