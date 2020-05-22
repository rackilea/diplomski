public class MainActivity extends Activity {
    // ...
    public void sendMessage(View view){
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.EditText);
        String message = editText.getText().toString();
        Bundle bundle = new Bundle();
        bundle.putString(DisplayMessageActivity.KEY_BUNDLE_SOME_VALUE, message);
        bundle.putString(DisplayMessageActivity.KEY_BUNDLE_SOME_OTHER_VALUE, someOtherValue);
        intent.putExtras(bundle);
        startActivity(intent);
    }
    // ...
}