@RequestMapping(value="/Organization" method=RequestMethod.GET)
    public String getOrganization(HttpServletRequest request,
        @ModelAttribute("form") BaseForm form) {
        if (form.getClass() != OrganizationForm.class) {
            form = new OrganizationForm();
            request.getSession().setAttribute("form", form);
        }
        ...
        return "orgView";
    }