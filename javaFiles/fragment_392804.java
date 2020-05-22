try {

            getFacade().create(current);

            for(Organisation org : current.getOrganisationCollection()) {
                org.getProjectCollection().add(current);
                ejbOrganisationFacade.edit(org);
            }

            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/resources/Bundle").getString("ProjectCreated"));
            return prepareCreate();
        } catch (Exception e) {