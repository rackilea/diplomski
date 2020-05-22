case R.id.menu_roll_call_opt_in:
//saveing something into Parse -- (a database online, check Parse.com if you want more info, but just treat this like I am saving something into the cloud)
currentUser.put("somethingBoolean", false); 
currentUser.saveInBackground(new SaveCallback(){

@Override
public void done(ParseException e) { //once data has been put into the cloud
    progressDialog.dismiss();//dismiss the dialog
    supportInvalidateOptionsMenu();//refreshes the options menu
}
});

return true;