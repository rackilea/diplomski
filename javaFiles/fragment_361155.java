Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "en-US");
try {
    startActivityForResult(intent, 1);
} catch (ActivityNotFoundException a) {
    Toast t = Toast.makeText(getApplicationContext(), "Opps! Your device doesn't support Speech to Text",Toast.LENGTH_SHORT);
    t.show();
}