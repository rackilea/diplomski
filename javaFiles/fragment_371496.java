@Override
protected void onPostExecute(String result) {
    Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();
    Intent i = new Intent(MainActivity.this, UserAreaActivity.class);
    i.putExtra("result", result);
    startActivity(i);
}