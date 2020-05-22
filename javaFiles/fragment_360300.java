@RequestMapping(value = "/submitobject", method = RequestMethod.POST,produces = "application/json")
@ResponseBody
public MyObject saveOrUpdateHrEmployee(@RequestBody @Validated MyObject myObject,
    BindingResult result, Model model, final RedirectAttributes redirectAttributes) 

{
.
.
.    
}