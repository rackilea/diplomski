public static void importEncryptedDB(Context context) 
{
    try {
        String appName = context.getResources().getString(R.string.app_name);
        File file = new File(Environment.getExternalStorageDirectory() + "/" + appName + "/");
        if(!file.exists())
        {
            file.mkdirs();
        }

        File sd = Environment.getExternalStorageDirectory();

        if (sd.canWrite())
        {
            File data = Environment.getDataDirectory();
            String currentDBPath = "//data//" + context.getPackageName() + "//databases//" + DB_NAME;
            String backupDBPath  = "/" + appName + "/" + DB_NAME;
            File currentDB = new File(sd, backupDBPath);
            File backupDB = new File(data, currentDBPath);

            FileInputStream src = new FileInputStream(currentDB);
            FileOutputStream dst = new FileOutputStream(backupDB);

            // KEY Length 16 byte
            SecretKeySpec sks = new SecretKeySpec("1234567890123456".getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, sks);

            CipherInputStream cis = new CipherInputStream(src, cipher);

            int b;
            byte[] d = new byte[8];
            while((b = cis.read(d)) != -1) {
                dst.write(d, 0, b);
            }
            dst.flush();
            src.close();
            dst.close();
            cis.close();

            Log.e("IMPORT_DB", "Database has been imported.");
        }
        else
        {
            Log.e("IMPORT_DB", "No storage permission.");
        }
    } catch (Exception e) {
        e.printStackTrace();
        Log.e("IMPORT_DB", "Error importing database!");
    }
}