private static final String MY_INTRO_SETTINGS = "my_intro_settings";
private static final String MY_INTRO_TEXT_KEY = "my_intro_text";

@Override
public void createPartControl(Composite parent) {
    this.text = new Text(parent, SWT.BORDER);

    // try to load the settings
    IDialogSettings settings = Activator.getDefault().getDialogSettings();
    IDialogSettings section = settings.getSection(MyIntroPart.MY_INTRO_SETTINGS);
    if (section != null) {
        // set the restored text string in the text widget
        this.text.setText(section.get(MyIntroPart.MY_INTRO_TEXT_KEY));
    }

    // register the part listener
    getIntroSite().getWorkbenchWindow().getPartService().addPartListener(this);
}