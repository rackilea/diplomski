ButtonClick.setOnClickListener(new View.OnClickListener() {

        public void onClick(View v) {
            Uri uri;
            try { 
                uri = Uri.parse("http://www.stackoverflow.com");
                browserIntent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(browserIntent);
            } catch (URISyntaxException e) {
                e.printStackTrace();
            } 

        } 
    });}}