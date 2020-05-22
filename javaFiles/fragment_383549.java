public void buttonOnClick(View v) {
   for(String ext: extensions){ 
     if (urlBar.length() > 0 && urlBar.getText().toString().endsWith(ext)) {
         webView1.loadUrl(urlBar.getText().toString());
         break;
     }
   }
}