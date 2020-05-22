@Override
public void onBackPressed() {
    Intent intent = new Intent(this, DispatcherActivity.class);
    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    intent.addExtra("exit", "true");
    startActivity(intent);
}