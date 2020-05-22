protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder ){
    try {
        binder.registerCustomEditor(Integer.class, "ssnField", new IntegerPropertyEditor());
    } catch (UnsupportedEncodingException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }


}