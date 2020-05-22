public class MyActivity extends AppCompatActivity{
     @BindView(R.id.bottom_navigationbar)
     AHBottomNavigation bottomNavigation;

   onCreate(){

    bottomNavigation.addItem(new AHBottomNavigationItem("Title1", iconID1);
    bottomNavigation.addItem(new AHBottomNavigationItem("Title2", iconID2);
    bottomNavigation.addItem(new AHBottomNavigationItem("Title3", iconID3);
    bottomNavigation.addItem(new AHBottomNavigationItem("Title4", iconID4);

    bottomNavigation.setAccentColor(ContextCompat.getColor(this, themeColor));

    //will always show titles
    bottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW); 
}}