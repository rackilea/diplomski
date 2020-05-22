prefs = getActivity().getSharedPreferences("spa", Context.MODE_PRIVATE);
// Find the string we want
String someId = prefs.getString("someId","");
final Editor editor = prefs.edit();
// To stop a trip being added in onResume etc.
if(someId != prefs.getString("previous-trip", "")){
    showLog.setText(someId + prefs.getString("previous", ""));
} else {
    // Without this else, we'd have a blank box again
    showLog.setText(prefs.getString("previous", ""));
}
// Store the latest trip that was added
editor.putString("previous-trip", someId);
// Store everything that's in the box so far for next time
editor.putString("previous", showLog.getText().toString());
// Commit to the prefs
editor.commit();