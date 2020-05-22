switch (settings.getItemId()) {
    // If home icon is clicked return to main Activity
    case android.R.id.home:
      Intent intent = new Intent(this, MainActivity.class);
      intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
      startActivity(intent);
      break; 
}