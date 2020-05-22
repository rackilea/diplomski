public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    // Intent for getting installed apps.
    Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
    mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);

    // Get installed apps
    List<ResolveInfo> appList = this.getPackageManager().queryIntentActivities(mainIntent, 0);

    // Make new list for package names and fill the list.
    List<String> packageNameList = new ArrayList<String>();
    for (ResolveInfo resolveInfo : appList) {
        packageNameList.add(resolveInfo.activityInfo.packageName);
    }

    // Set the list adapter.
    setListAdapter(new ArrayAdapter<String>(this, R.layout.simple, packageNameList));
}

public void onListItemClick(ListView l, View v, int position, long id)
{
    // Get the TextView that was clicked.
    TextView view = (TextView)v;

    // Get the text from the TextView.
    String packageName = (String)view.getText();

    // Open AppDetails for the selected package.
    showInstalledAppDetails(packageName);
}

public void showInstalledAppDetails(String packageName) {
    final int apiLevel = Build.VERSION.SDK_INT;
    Intent intent = new Intent();

    if (apiLevel >= 9) {
        intent.setAction(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        intent.setData(Uri.parse("package:" + packageName));
    } else {
        final String appPkgName = (apiLevel == 8 ? "pkg" : "com.android.settings.ApplicationPkgName");

        intent.setAction(Intent.ACTION_VIEW);
        intent.setClassName("com.android.settings", "com.android.settings.InstalledAppDetails");
        intent.putExtra(appPkgName, packageName);
    }

    // Start Activity
    startActivity(intent);
}