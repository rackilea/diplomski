EditText txtData = (EditText) findViewById(R.id.editText1);
FileWriterTask task = new FileWriterTask();
task.execute(txtData.getText().toString());

public class FileWriterTask extends AsyncTask<String, Void, Void> {
  @Override
  protected Void doInBackground(String... params) {
    // Do your filewriting here. The text should now be in params[0]
  }
}