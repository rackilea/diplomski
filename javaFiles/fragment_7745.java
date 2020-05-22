Intent intent = new Intent(Intent.ACTION_VIEW);
    intent.setData(Uri.parse("https://duckduckgo.com/?q=" + subject));

    try {
        intent.setPackage("com.duckduckgo.mobile.android");
        context.startActivity(intent);
    } catch (ActivityNotFoundException a) {
        intent.setPackage(null);
        context.startActivity(intent);
    }