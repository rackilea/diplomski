@InitBinder
public void initBinder(WebDataBinder binder) {
    binder.registerCustomEditor(
        String[].class,
        new StringArrayPropertyEditor(null)); 
}