...
    if (id == R.id.action_settings) {

        makeText(this, "Settings Menu Item Clicked", LENGTH_SHORT).show();

        Intent intent = new Intent(this, AudioPlayerSettings.class);
        startActivity(intent);

        return true;
    }
    ...