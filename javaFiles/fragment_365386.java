@InitBinder
public void initBinder(WebDataBinder binder) {
    binder.registerCustomEditor(Organization.class,
            new PropertyEditorSupport() {

                @Override
                public void setAsText(String text) {
                    Organization organization = dao.find(Organization.class,
                            Integer.parseInt(text));
                    setValue(organization);
                }
            });
}