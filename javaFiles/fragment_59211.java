private void shareIntent() {
     Intent shareIntent = new Intent(Intent.ACTION_SEND);
     shareIntent.setType("image/jepg");
     shareIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("file://"+data.get(pos).getUrl()));
     startActivity(Intent.createChooser(shareIntent, "Share image"));
}