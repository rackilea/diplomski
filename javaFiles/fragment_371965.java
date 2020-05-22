Intent audioIntent = new Intent(android.content.Intent.ACTION_VIEW);
    audioIntent.setDataAndType(Uri.fromFile(Opener.file), "audio/*");
    List<ResolveInfo> audio = packageManager.queryIntentActivities(audioIntent, 0);
    for (ResolveInfo info : audio){
        String label = info.loadLabel(packageManager).toString();
        Drawable icon = info.loadIcon(packageManager);
        String packageName = info.activityInfo.packageName;
        String name = info.activityInfo.name;
        iconlabel.add(a.new HolderObject(label, icon, audioIntent, "audio/*", packageName, name));
    }