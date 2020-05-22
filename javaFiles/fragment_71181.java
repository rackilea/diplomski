@InitBinder
public void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
    DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
    df.setLenient(false);
    CustomDateEditor editor = new CustomDateEditor(df, true); // second argument 'allowEmpty' is set to true to allow  null/empty values.
    binder.registerCustomEditor(Date.class, editor);
}