@ActionMapping(value="/someUrl")
public void createEmp(@ModelAttribute("empBean") Employee emp, BindingResult bindingResult,ActionRequest req,ActionResponse res)
{
    for( FieldError fieldError : bindingResult.getFieldErrors() )
        System.out.println(fieldError.getField() +" : "+fieldError.getDefaultMessage());
    System.out.println("------------->"+emp);
}