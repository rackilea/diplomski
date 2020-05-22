Intent intent = getPackageManager().getLaunchIntentForPackage("com.example.myapp");

if(intent.resolveActivity(context.getPackageManager()) != null){  //Open app if installed
    startActivity(intent);
}else{//Send to play store to download or instant app solution
try {
    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.example.myapp")));
} catch (ActivityNotFoundException anfe) {
    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.example.myapp")));
}
}