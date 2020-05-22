protected class CustomApproveSelectionAction extends BasicFileChooserUI.ApproveSelectionAction {

    @Override
    public void actionPerformed(ActionEvent e) {
        String filename = getFileName();
        // using a custom pattern to accept valid charachters only:
        Matcher matcher = pattern.matcher(filename);

        if (matcher.matches()) { 
            // this is the good case, just let the super implementation do what have to do.
            super.actionPerformed(e);
        } else {
            // this is the bad case, we must warn the user and don't let the super implementation take effect.
            // display an error message similar like notepad does it.
        }
    }
}