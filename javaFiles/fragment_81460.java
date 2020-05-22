private void sendImplicitOrderedBroadcast(Intent i, String receiverPermission,
                                            BroadcastReceiver resultReceiver,
                                            Handler scheduler, int initialCode,
                                            String initialData,
                                            Bundle initialExtras) {
    PackageManager pm=getPackageManager();
    List<ResolveInfo> matches=pm.queryBroadcastReceivers(i, 0);

    Collections.sort(matches,
      (left, right) -> right.filter.getPriority()-left.filter.getPriority());

    for (ResolveInfo resolveInfo : matches) {
      Intent explicit=new Intent(i);
      ComponentName cn=
        new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName,
          resolveInfo.activityInfo.name);

      explicit.setComponent(cn);
      sendOrderedBroadcast(explicit, receiverPermission, resultReceiver,
        scheduler, initialCode, initialData, initialExtras);
    }
  }