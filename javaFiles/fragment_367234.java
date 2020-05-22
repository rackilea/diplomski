public void urdu(View view) {
    final Context context = this;
    new Utilssss(context, new Utilssss.UtilssssCallback() {
        @Override
        public void onResult(String string) {
            Toast.makeText(context, string, Toast.LENGTH_LONG).show();
            Intent i = new Intent(context, MainPage.class);
            i.putExtra(LANGUAGE, "urdu");
            context.startActivity(i);
        }
    }).execute("http://192.168.1.2/eWorldLiterature/urdu/index.txt");
}