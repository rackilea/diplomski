@RequestMapping(method=RequestMethod.GET)
public String showForm(Model model){

    FormBean formBean = new FormBean();
    formBean.setIds(new ArrayList<Integer>(Arrays.asList(1,2,3,4,5)));
    model.addAttribute("formBean", formBean);               
    return "form";
}