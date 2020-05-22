@RequestMapping(value = "/changeme", params = { "save" })
public String save(@ModelAttribute BoxesForm form, final ModelMap m) {
    // do what you need with form.getCheckboxes() ...
    m.addAttribute("centers", /*params*/);
    return "clustering";
}

public class BoxesForm {
    List<Boolean> checkboxes;
    // getter and setter omitted ...
}