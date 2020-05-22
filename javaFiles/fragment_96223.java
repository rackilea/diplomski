@Override
public boolean onOptionsItemSelected(MenuItem item) {

    switch (item.getItemId()) {
        case R.id.guessingGame:
            Intent intent = new Intent(GameCentral.this, Task3Activity.class);
            intent.putExtra("PlayerName", "Name");

            startActivity(intent);
            return true;
        default:
            return super.onOptionsItemSelected(item);
    }
}