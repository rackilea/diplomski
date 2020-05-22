@Override
public void partClosed(IWorkbenchPartReference partRef) {
    // remove part listener from part service
    getIntroSite().getWorkbenchWindow().getPartService().removePartListener(this);

    IDialogSettings settings = Activator.getDefault().getDialogSettings();

    // get the section of the text
    IDialogSettings section = settings.getSection(MyIntroPart.MY_INTRO_SETTINGS);

    // if it doesn't exist, create it
    if (section == null) {
        section = settings.addNewSection(MyIntroPart.MY_INTRO_SETTINGS);
    }

    // put text from text field in section
    section.put(MyIntroPart.MY_INTRO_TEXT_KEY, this.text.getText());
}