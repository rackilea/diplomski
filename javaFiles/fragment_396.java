@RequestMapping(value="/getSpecificLayout", method = RequestMethod.GET)
public String getSpecificLayout(Stirng subjectName, ModelMap model){
    Iterable<Layouts> layouts = getSpecificLayout(String subjectName);
    model.addAttribute("layouts", layouts);
    return "listLayouts";
}