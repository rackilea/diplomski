public void funktionTeilen(String Datei) {

    try {
        File tmpFile = new File(this.getCacheDir() + "/tmpfile.mp3");
        InputStream in = getResources().openRawResource(R.raw.meise1);
        FileOutputStream out = new FileOutputStream(tmpFile, false);
        byte[] buff = new byte[1024];
        int read = 0;

        try {
            while ((read = in.read(buff)) > 0) {
                out.write(buff, 0, read);
            }
        } finally {
            in.close();
            out.close();
            /* if (tmpFile.exists()) {
                Toast.makeText(MainActivity.this, tmpFile.getAbsolutePath(), Toast.LENGTH_LONG).show();
            } */
        }

        Uri uri = FileProvider.getUriForFile(this, BuildConfig.APPLICATION_ID, tmpFile.getAbsoluteFile());
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("audio/mpeg3");
        share.putExtra(Intent.EXTRA_STREAM, uri);
        startActivity(Intent.createChooser(share, "Audio teilen"));

    } catch (Exception e) {
        Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_LONG).show();
    }

}