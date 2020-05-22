public void tap(View view) {

    final AlertDialog.Builder tapAlert = new AlertDialog.Builder(this);
    ...
    if (firstTap) {
        tapAlert.show();
        firstTap = false;
    }