@RequestMapping("/send")
public ModelAndView getList(HttpServletRequest req,FormStruct formStruct)
{
    Iterator<RowStruct> it = formStruct.getArrData().iterator();
    while (it.hasNext()) {
        if (it.next() == null)
            it.remove();
    }
    ModelAndView model = new ModelAndView();

}