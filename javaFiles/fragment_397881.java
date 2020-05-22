if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.N) {
  actionBar.setTitle(Html.fromHtml(..., Html.FROM_HTML_MODE_LEGACY));
}
else {
  actionBar.setTitle(Html.fromHtml(...));
}