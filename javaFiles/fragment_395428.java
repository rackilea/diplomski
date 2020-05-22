try {
    Intent intent = new Intent("com.google.zxing.client.android.SCAN");
    intent.putExtra("SCAN_MODE", "QR_CODE_MODE"); // "PRODUCT_MODE for bar codes

    startActivityForResult(intent, 0);
} catch (Exception e) {    
    Uri marketUri = Uri.parse("market://details?id=com.google.zxing.client.android");
    Intent marketIntent = new Intent(Intent.ACTION_VIEW,marketUri);
    startActivity(marketIntent);
}