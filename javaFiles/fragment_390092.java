TabWidget tabWidget = (TabWidget) findViewById(android.R.id.tabs);
final int tabChildrenCount = tabWidget.getChildCount();
for (int i=0; i< tabChildrenCount; i++)
{
        // change the value 110 to whatever suits you for tab width
    tHost.getTabWidget().getChildAt(i).getLayoutParams().width = 110;
}