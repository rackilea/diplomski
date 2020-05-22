@RequestMapping({"/foo/**", "/bar/**"})
@ResponseBody
public String doStuff(HttpServletRequest request) throws Exception
{
    String path = request.getRequestURI();
    // Do stuff with path
}