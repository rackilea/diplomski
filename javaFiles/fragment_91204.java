@InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(AdminRole.class,  new PropertyEditorSupport() {
            public void setAsText(String name) {
                AdminRole adminRole = terminalAdminService.findRoleByName(name);
                setValue(adminRole);
            }
        });
    }