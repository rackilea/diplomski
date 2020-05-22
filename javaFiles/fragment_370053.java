public class MainActivity extends TabActivity {

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    //setContentView(R.layout.activity_main);

    TabHost mTabHost = getTabHost();

    mTabHost.addTab(mTabHost.newTabSpec("first").setIndicator("First").setContent(new Intent(this  ,FirstActivity.class )));
    mTabHost.addTab(mTabHost.newTabSpec("second").setIndicator("Second").setContent(new Intent(this , SecondActivity.class )));
    mTabHost.setCurrentTab(0);


}
}