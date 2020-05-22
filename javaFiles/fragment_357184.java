public static Intent getShareIntent(File file) {
    Intent intent = new Intent();
    intent.setAction(Intent.ACTION_SEND);
    intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
    intent.setType("application/vnd.android.package-archive");
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

    return intent;
}