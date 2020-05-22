Intent shareIntent = new Intent(android.content.Intent.ACTION_SEND);
shareIntent.setType("text/plain");
shareIntent.putExtra(android.content.Intent.EXTRA_TEXT,"this is a string");
shareIntent.setType("image/png");
shareIntent.putExtra(android.content.Intent.EXTRA_STREAM,uri); //Share the image on Facebook
PackageManager pm = getApplicationContext().getPackageManager();
List<ResolveInfo> activityList = pm.queryIntentActivities(shareIntent, 0);
                    for (final ResolveInfo app : activityList) {
                        if ((app.activityInfo.name).contains("facebook")) {
                            final ActivityInfo activity = app.activityInfo;
                            final ComponentName name = new ComponentName(
                                        activity.applicationInfo.packageName,
                                        activity.name);
                            shareIntent.addCategory(Intent.CATEGORY_LAUNCHER);
                            shareIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                                | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
                            shareIntent.setComponent(name);
                            startActivity(shareIntent);
                            break;
                                }
                            }