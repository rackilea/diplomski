Uri uri = Uri.parse("market://details?id=" + context.getPackageName());
Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
try {
    context.startActivity(goToMarket);
} catch (ActivityNotFoundException e) {
    UtilityClass.showAlertDialog(context, ERROR, "Couldn't launch the market", null, 0);
}