@RequestMapping(value = "get_label", produces = "text/html; charset=UTF-8")
public @ResponseBody String getLabel(HttpServletResponse response)
{
    String str = "בדיקה";

    return str;
}