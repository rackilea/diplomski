protected void installDefaults() {
    Locale l = getFileChooser().getLocale();

    listViewBorder = UIManager.getBorder("FileChooser.listViewBorder");
    listViewBackground = UIManager.getColor("FileChooser.listViewBackground");
    listViewWindowsStyle = UIManager.getBoolean("FileChooser.listViewWindowsStyle");
    readOnly = UIManager.getBoolean("FileChooser.readOnly");

    // TODO: On windows, get the following localized strings from the OS

    viewMenuLabelText = UIManager.getString("FileChooser.viewMenuLabelText", l);
    refreshActionLabelText = UIManager.getString("FileChooser.refreshActionLabelText", l);
    newFolderActionLabelText = UIManager.getString("FileChooser.newFolderActionLabelText", l);

    viewTypeActionNames = new String[VIEWTYPE_COUNT];
    viewTypeActionNames[VIEWTYPE_LIST] = UIManager.getString("FileChooser.listViewActionLabelText", l);
    viewTypeActionNames[VIEWTYPE_DETAILS] = UIManager.getString("FileChooser.detailsViewActionLabelText", l);

    kiloByteString = UIManager.getString("FileChooser.fileSizeKiloBytes", l);
    megaByteString = UIManager.getString("FileChooser.fileSizeMegaBytes", l);
    gigaByteString = UIManager.getString("FileChooser.fileSizeGigaBytes", l);
    fullRowSelection = UIManager.getBoolean("FileView.fullRowSelection");

    renameErrorTitleText = UIManager.getString("FileChooser.renameErrorTitleText", l);
    renameErrorText = UIManager.getString("FileChooser.renameErrorText", l);
    renameErrorFileExistsText = UIManager.getString("FileChooser.renameErrorFileExistsText", l);
}