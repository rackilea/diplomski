try {
     ...
    return result;
} catch (MalformedURLException e1) {
    Toast.makeText(MainActivity.this, "MalformedURLException", Toast.LENGTH_SHORT).show();
} catch (IOException e2) {
Toast.makeText(MainActivity.this, "IOException", Toast.LENGTH_SHORT).show();
} catch (Exception e) {
    Toast.makeText(MainActivity.this, "General exception (doInBackground)", Toast.LENGTH_SHORT).show();
}