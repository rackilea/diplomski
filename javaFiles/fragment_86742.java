String deviceInfo="Device Info:";
deviceInfo += "\n OS Version: " + System.getProperty("os.version") + "(" + android.os.Build.VERSION.INCREMENTAL + ")";
deviceInfo += "\n OS API Level: " + android.os.Build.VERSION.SDK_INT;
deviceInfo += "\n Device: " + android.os.Build.DEVICE;
deviceInfo += "\n Model (and Product): " + android.os.Build.MODEL + " ("+ android.os.Build.PRODUCT + ")";
Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","exmaple@gmail.com", null));
 emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Device Info");
 emailIntent.putExtra(Intent.EXTRA_TEXT, deviceInfo);
 startActivity(Intent.createChooser(emailIntent, "Send email..."));