File sourceFile = new File("//mnt/sdcard/file.apk"); 
Intent intent = new Intent();
intent.setAction(Intent.ACTION_SEND);
Intent.setType("image/jpeg"); 
intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(sourceFile));
startActivity(intent);