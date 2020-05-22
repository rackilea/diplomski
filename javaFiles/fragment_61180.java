@Override
public void onBackPressed()
{
    Intent intent = new Intent(this, First.class);
    finish(); // to simulate "restart" of the activity.
    startActivity(intent);
}