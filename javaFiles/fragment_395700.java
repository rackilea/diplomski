@ModelAttribute("foo") 
public FOOBEAN getFoo(){ 
    return new FOOBEAN();
}

public @ResponseBody Boolean baz(@ModelAttribute("foo") FOOBEAN fooBean, BindingResult result, HttpServletRequest qui) {
    // method body does here 
}