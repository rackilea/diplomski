private void importDB() {
        try {
            File sd = Environment.getExternalStorageDirectory();
            File data = Environment.getDataDirectory();
                if (sd.canWrite()) {
                String currentDBPath = "//data//" + "<package name>"
                        + "//databases//" + "<database name>";
                String backupDBPath = "<backup db filename>"; // From SD directory.
                File backupDB = new File(data, currentDBPath);
                File currentDB = new File(sd, backupDBPath);

            FileChannel src = new FileInputStream(backupDB).getChannel();
            FileChannel dst = new FileOutputStream(currentDB).getChannel();
            dst.transferFrom(src, 0, src.size());
            src.close();
            dst.close();
            Toast.makeText(getApplicationContext(), "Import Successful!",
                    Toast.LENGTH_SHORT).show();

        }
    } catch (Exception e) {

        Toast.makeText(getApplicationContext(), "Import Failed!", Toast.LENGTH_SHORT)
                .show();

    }
}

private void exportDB() {
    try {
        File sd = Environment.getExternalStorageDirectory();
        File data = Environment.getDataDirectory();

        if (sd.canWrite()) {
            String currentDBPath = "//data//" + "<package name>"
                    + "//databases//" + "<db name>";
            String backupDBPath = "<destination>";
            File currentDB = new File(data, currentDBPath);
            File backupDB = new File(sd, backupDBPath);

            FileChannel src = new FileInputStream(currentDB).getChannel();
            FileChannel dst = new FileOutputStream(backupDB).getChannel();
            dst.transferFrom(src, 0, src.size());
            src.close();
            dst.close();
            Toast.makeText(getApplicationContext(), "Backup Successful!",
                    Toast.LENGTH_SHORT).show();

        }
    } catch (Exception e) {

        Toast.makeText(getApplicationContext(), "Backup Failed!", Toast.LENGTH_SHORT)
                .show();

    }
}