JDialogSeach dialog = new JDialogSeach(); // seach box implementation of JDialog
switch (dialog.showSearchDialog()) {
    case JDialogSeach.OK_STATE:
        mySearchResult = dialog.getSearchResult();
        break;
}
dialog.setVisible(true);