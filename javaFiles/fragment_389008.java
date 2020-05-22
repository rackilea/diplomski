intentAPP.addAction(Intent.ACTION_PACKAGE_ADDED);
            intentAPP.addAction(Intent.ACTION_PACKAGE_CHANGED);
            intentAPP.addAction(Intent.ACTION_PACKAGE_DATA_CLEARED);
            intentAPP.addAction(Intent.ACTION_PACKAGE_INSTALL);
            intentAPP.addAction(Intent.ACTION_PACKAGE_REMOVED);
            intentAPP.addAction(Intent.ACTION_PACKAGE_REPLACED);
            intentAPP.addAction(Intent.ACTION_PACKAGE_RESTARTED);

//for storing list in db

    for (int i = 0; i < AppsP.size() && i < Apps.size(); i++) {

                    DB.insertStmt.bindString(1, URLDecoder.decode(AppsP.get(i)));
                    DB.insertStmt.bindString(2, URLDecoder.decode(Apps.get(i)));
                    DB.insertStmt.bindString(3, 1 + "");
                    DB.insertStmt.bindString(4, "false");
                    DB.insertStmt.executeInsert();

                }

//adding package notification
if (intent.getAction().equalsIgnoreCase(Intent.ACTION_PACKAGE_ADDED)) {
            String added_package = intent.getData().toString();
            Log.i("PackageReceiver", "Package Added = " + added_package);
            Intent Intent_add = new Intent();
            Intent_add.setClass(context, ServiceAppsAdd.class);
            Intent_add.putExtra("Package_Name", added_package.substring(8));
            Intent_add.putExtra("Status", status_new);
            context.startService(Intent_add);