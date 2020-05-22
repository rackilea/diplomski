public void showAlertCreate(String title, String description) {
    AlertDialog.Builder builder;
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
    } else {
        builder = new AlertDialog.Builder(this);
    }
    builder.setTitle(title)
            .setMessage(description)
            .setPositiveButton(R.string.yes_create, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    // Start Youtube WebView to create Channel
                    Intent intent = new Intent(mContext, WebViewActivity.class);
                    startActivityForResult(intent, 777);
                }
            })
            .setIcon(android.R.drawable.ic_dialog_alert)
            .show();
}