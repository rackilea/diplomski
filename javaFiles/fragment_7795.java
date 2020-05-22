if (requestCode == 777) {
    if(resultCode == RESULT_OK) {
        // Receive intent from WebView, if new Channel, repost comment/reply
        String created = data.getStringExtra("created");
        if(created.equals("yes")) {
            // Posting the comment again
            getResultsFromApi();
        }
    }
}