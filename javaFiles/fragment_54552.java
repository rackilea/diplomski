@Override
public void onClick(View v) {
    final MainDatabase db = new MainDatabase(getApplicationContext());

    switch (v.getId()) {
        case R.id.tvBackUp:
            String outFileName = Environment.getExternalStorageDirectory() + 
File.separator + getResources().getString(R.string.app_name) + File.separator;
            localBackup.performBackup(db, outFileName);
            break;
        case R.id.tvRestore:
            File folder = new File(Environment.getExternalStorageDirectory() + File.separator + getApplicationContext().getResources().getString(R.string.app_name));
            if (folder.exists()) {

                final File[] files = folder.listFiles();

                if (files.length == 0) {
                    Toast.makeText(this, "No any Backup", Toast.LENGTH_SHORT).show();
                } else {
                    localBackup.performRestore(db);
                }
            }

            break;
    }
}