mPrefs = PreferenceManager.getDefaultSharedPreferences(this);
// second argument is the default to use if the preference can't be found
Boolean welcomeScreenShown = mPrefs.getBoolean(welcomeScreenShownPref, false);
int savedVersion = mPrefs.getInt("savedVersiono", 0);
PackageInfo pinfo;
int currentVersion = 0;
try{
    pinfo = getPackageManager().getPackageInfo(getPackageName(), 0);
    currentVersion = pinfo.versionCode;
}catch (NameNotFoundException ex){

}

if (!welcomeScreenShown || (currentVersion > savedVersion)) {
   //Popup Show

    String whatsNewTitle = getResources().getString(R.string.whatsNewTitle);
    //Changelog Text
    String whatsNewText = getResources().getString(R.string.whatsNewText);
    new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle(whatsNewTitle).setMessage(whatsNewText).setPositiveButton(
                R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();
    SharedPreferences.Editor editor = mPrefs.edit();
    editor.putBoolean(welcomeScreenShownPref, true);
    editor.putInt("savedVersiono", currentVersion);
    editor.apply(); //Needs to be set!
}