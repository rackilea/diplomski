public void share(Sound sound) {
    Gdx.files.internal(sound.file).copyTo(Gdx.files.external("/skrelpoid/KJ/share/" + sound.file));
    File file = new File(Environment.getExternalStorageDirectory().getPath() + "/skrelpoid/KJ/share/" + sound.file);
    Uri uri = Uri.fromFile(file);
    Intent sendIntent = new Intent();
    sendIntent.setAction(Intent.ACTION_SEND);
    sendIntent.putExtra(Intent.EXTRA_STREAM, uri);
    sendIntent.setType(MimeTypeMap.getSingleton().getMimeTypeFromExtension(sound.getExtension()));
    app.startActivity(Intent.createChooser(sendIntent, "Teile den Sound"));
}