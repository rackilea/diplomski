@InitBinder
public void initBinder(WebDataBinder binder){
    binder.setAllowedFields(new String[]{
        "name", "username", "phoneNumber"
    });
}