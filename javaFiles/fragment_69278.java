public static Intent getOpenFacebookIntent(Context context) {

       try {
        context.getPackageManager().getPackageInfo("com.facebook.katana", 0);
        return new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/5676133521"));
       } catch (Exception e) {
        return new Intent(Intent.ACTION_VIEW, Uri.parse("https://touch.facebook.com/androiddevs"));
       }
    }
}