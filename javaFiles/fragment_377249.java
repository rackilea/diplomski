public void clickweb(View v) {

    Toast.makeText(MainActivity.this, "Web view selected", Toast.LENGTH_LONG).show();
    Intent i1 = new Intent(MainActivity.this,LoadWeb.class);

    switch(v.getId()) {
        case R.id.button1:
            i1.putExtra("URL", "https://www.google.co.in");
            break;
        case R.id.button2:
            il.putExtra("URL", "https://www.facebook.com");
            break;
    }

    startActivity(i1);
}