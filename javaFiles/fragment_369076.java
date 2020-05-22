Intent share = new Intent();
    share.setAction(Intent.ACTION_SEND_MULTIPLE);
    share.setType("*/*");

    share.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

    ArrayList<Uri> files = new ArrayList<Uri>();
    files.add(ShareImage);
    files.add(uri);
    share.putExtra(Intent.EXTRA_STREAM, uri);
    share.putParcelableArrayListExtra(Intent.EXTRA_STREAM, files);
    share.putExtra(Intent.EXTRA_TEXT, "Text ...");
    share.putExtra(Intent.EXTRA_SUBJECT, "text ....");
    share.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
    context.startActivity(Intent.createChooser(share, "share"));