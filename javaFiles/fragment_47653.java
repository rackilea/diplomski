@RequestMapping("get_label")
public @ResponseBody String getLabel(HttpServletResponse response)
{
    String str = "בדיקה";

    //set encoding explicitly
    response.setCharacterEncoding("UTF-8");

    return str;
}