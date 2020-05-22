private boolean saveDone = false;


public boolean performOk() {

  if (!saveDone) {
    saveDone = true;

    store.setValue(Constants.ENABLE_DEFAULT_COLOR, this.defaultColoringCheckBox.getSelection());
    PreferencesUtil.addToPreferenceStore(viewer.getTable());
    PreferencesUtil.savePreferences();
  }

  return super.performOk();
}