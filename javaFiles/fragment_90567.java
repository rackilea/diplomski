boolean loggedin = PreferenceData.getUserLoggedInStatus(YouactivityName.this);

if (loggedin == true)
{
    accountframe.setVisibility(View.VISIBLE);
    accounttv.setText((CharSequence) appPref);
}