case R.id.Facebook:
    Intent facebook = getPackageManager().getLaunchIntentForPackage("com.facebook.katana");
    if (facebook == null) {
        Toast.makeText(this,"Facebook is not installed ",Toast.LENGTH_LONG).show();
    } else {
       startActivity(facebook);
    }
    return true;