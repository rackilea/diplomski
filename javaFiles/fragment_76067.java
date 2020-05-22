private void shareNews() {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, "Put Data Here");
        startActivity(Intent.createChooser(shareIntent,getString("How do you want to share")));
    }