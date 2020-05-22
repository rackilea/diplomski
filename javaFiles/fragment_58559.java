// Check to see if a recognition activity is present
// if running on AVD virtual device it will give this message. The mic
// required only works on an actual android device
PackageManager pm = getPackageManager();
List activities = pm.queryIntentActivities(new Intent(
RecognizerIntent.ACTION_RECOGNIZE_SPEECH), 0);
if (activities.size() != 0) {
    voiceButton.setOnClickListener(this);
} else {
    voiceButton.setEnabled(false);
    voiceButton.setText("Recognizer not present");
}