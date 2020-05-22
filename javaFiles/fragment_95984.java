@Override
public void onClick(View v) {
    Intent playIntent = new Intent(PlayActivity.this, PlayActivity.class);
    startActivity(playIntent);
    isPaused=true;
    finish();
}