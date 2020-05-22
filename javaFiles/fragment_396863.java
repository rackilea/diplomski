item.add(new Label("active"){
    public IConverter getConverter(Class type){
        return new IConverter(){
            public String convertToString(Object value, Locale locale){
                if (Boolean.TRUE.equals(value) { return "enabled"; }
                else if (Boolean.FALSE.equals(value) { return "disabled"; }
                else { return null; }
            }
            public Object convertToObject(String value, Locale locale){
                // Not needed, only used by FormComponents
                return null;
            }
         }
    }
};