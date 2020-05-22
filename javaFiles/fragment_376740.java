private void selectItem(int position) {
Intent intent;
switch (position) {
    case 0:
            intent = new Intent(currentActivity, NewActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            currentActivity.startActivity(intent);

        break;
    case 1: // etc.