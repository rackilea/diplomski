@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (requestCode == 1000 && resultCode == Activity.RESULT_OK) {
        selectedSoundRawId = data.getIntExtra("soundRawId");
    }
}