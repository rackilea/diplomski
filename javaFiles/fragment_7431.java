imageView.setOnClickListener(new View.OnClickListener() {
    public void onClick(View v) {
        String url = "<!LINK TO APP IN PLAYSTORE>";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
});