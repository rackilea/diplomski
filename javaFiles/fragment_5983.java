@InitBinder
public void initBinder(WebDataBinder binder) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("YYYYMMDD");

    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
}