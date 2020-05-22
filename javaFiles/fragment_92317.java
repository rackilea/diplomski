IWizard wizard = getWizard();

IWizardPage page = wizard.getPage("page name");

IWizardContainer container = wizard.getContainer();

container.showPage(page);