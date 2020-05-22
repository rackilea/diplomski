@RequestMapping(params="cancel=true")
public String doCancel() {
    return "cancelView";
}


@RequestMapping(params="cancel!=true")
public String formSubmit(@ModelAttribute MyModelObject obj) {
    processForm(obj);
    return "successView";
}