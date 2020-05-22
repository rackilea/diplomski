public static void exportEncryptedDB(Context context)
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
            String currentDBPath= "//data//" + context.getPackageName() + "//databases//" + DB_NAME;
            String backupDBPath  = "/" + appName + "/" + DB_NAME;
            File currentDB = new File(data, currentDBPath);
            File backupDB = new File(sd, backupDBPath);

            FileInputStream src = new FileInputStream(currentDB);
            FileOutputStream dst = new FileOutputStream(backupDB);

            // KEY Length 16 byte
            SecretKeySpec sks = new SecretKeySpec("1234567890123456".getBytes(), "AES");
            // Create cipher
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, sks);

            CipherOutputStream cos = new CipherOutputStream(dst, cipher);
            byte[] b = new byte[8];
            int i = src.read(b);
            while (i != -1) {
                cos.write(b, 0, i);
                i = src.read(b);
            }
            src.close();
            dst.close();
            cos.flush();
            cos.close();

            Log.e("EXPORT_DB", "Database has been exported to\n" + backupDB.toString());
        }
        else
        {
            Log.e("EXPORT_DB", "No storage permission.");
        }
    } catch (Exception e) {
        e.printStackTrace();
        Log.e("EXPORT_DB", "Error exporting database!");
    }
}