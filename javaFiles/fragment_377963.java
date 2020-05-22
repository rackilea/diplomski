Intent intent = new Intent(android.content.Intent.ACTION_SEND);
    intent.putExtra(Intent.EXTRA_STREAM, uri);
    intent.putExtra(Intent.EXTRA_TEXT,"My Sales");
    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
    intent.setType("image/png");
    startActivity(intent);