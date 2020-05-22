Intent intent25 = new Intent(Intent.ACTION_MAIN).addCategory(
Intent.CATEGORY_LAUNCHER).setClassName("_APP_PACKAGE_NAME",
"_APP_PACKAGE_NAME.ACTIVITY_NAME").addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
.addFlags(Intent.FLAG_FROM_BACKGROUND).setComponent(new ComponentName("APP_PACKAGE_NAME",
"APP_PACKAGE_NAME.ACTIVITY_NAME"));
getApplicationContext().startActivity(intent25);