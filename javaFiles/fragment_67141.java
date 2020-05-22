public void setAsText(String text) {
        Object organization;
        if ("".equals(text)) {
            organization = (List < Organization > ) organizationService.getOrganizations();
        } else {
            organization = organizationService.getOrganization(Integer.parseInt(text));
        }

        setValue(organization);
    }