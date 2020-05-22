@InitBinder
public void initBinder(WebDataBinder binder) throws Exception {
    final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    final CustomDateEditor dateEditor = new CustomDateEditor(df, true) {
        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            if ("today".equals(text)) {
                setValue(new Date());
            } else {
                super.setAsText(text);
            }
        }
    };
    binder.registerCustomEditor(Date.class, dateEditor);
}