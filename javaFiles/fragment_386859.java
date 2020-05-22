try {
    loading = (TextView) findViewById(R.id.textView2);
    a = (Atom) new Atom().execute(null,null,null);
} catch (Exception e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
    finish();

}