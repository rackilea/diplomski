DropDownChoice projectLinksDropDown = new DropDownChoice("projectLinks", new Model(selectedProjectLink), projectLinkOptionList);
projectLinksDropDown.add(new AjaxFormComponentUpdatingBehavior("onChange") {
    @Override
    protected void onUpdate(AjaxRequestTarget target) {
        selectedProjectLink = (ProjectLink) getFormComponent().getConvertedInput();
        setResponsePage(selectedProjectLink.getRedirectPage());
    }
}
this.add(projectLinksDropDown);