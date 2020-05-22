Shell shell = .... get current shell

String id = "org.eclipse.ui.net.NetPreferences";

PreferenceDialog dialog 
   = PreferencesUtil.createPreferenceDialogOn(shell, id, new String[] {id}, null);

dialog.open();