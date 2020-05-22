File temporaryFile = null;
    try {
        temporaryFile = File.createTempFile(keyType.getKeyTypeString(), ".pem", context.getExternalCacheDir() );
        Utils.copy(new File(getFilesDir().getAbsolutePath()+"/"+ Utils.APP_OPERATOR_DIR, keyType.getKeyTypeString()+".pem"), temporaryFile);
    } catch (IOException e) {
        e.printStackTrace();
    }

File filelocation = new File(getFilesDir().getAbsolutePath()+"/MyApp", "FileName");
        Uri path = Uri.fromFile(filelocation);
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent .setType("vnd.android.cursor.dir/email");
        String to[] = {"mailmailmail@gmail.com"};
        emailIntent .putExtra(Intent.EXTRA_EMAIL, to);
        emailIntent .putExtra(Intent.EXTRA_STREAM, path);
        emailIntent .putExtra(Intent.EXTRA_SUBJECT, "Subject");
        startActivity(Intent.createChooser(emailIntent , "Send email..."));