public class tabviews extends TabActivity {
@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.tab);
    TabHost tab = getTabHost();

    TabSpec tab1 = (TabSpec) tab.newTabSpec("tb1");
    TabSpec tab2 = (TabSpec) tab.newTabSpec("tb2");


    tab1.setIndicator("Customer", null).setContent(
            new Intent(this, webview1.class));
    tab2.setIndicator("Item", null).setContent(
            new Intent(this, webview2.class));

    tab.addTab(tab1);
    tab.addTab(tab2);



}