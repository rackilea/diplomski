Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
            PackageManager pm = getPackageManager();

            final ResolveInfo mInfo = pm.resolveActivity(i, 0);

            PackageInfo pInfo = null;

            try {
                 pInfo = getPackageManager().getPackageInfo(
                        mInfo.activityInfo.packageName, PackageManager.GET_META_DATA);

            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }

            Toast.makeText(getApplicationContext()
                    ,pm.getApplicationLabel(mInfo.activityInfo.applicationInfo)
                            + " version " + pInfo.versionName,
                    Toast.LENGTH_LONG)
                    .show();