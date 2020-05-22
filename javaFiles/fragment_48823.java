public class YourActivity extends Activity {

    private Menu menu;
    private String inMenuTitle = "Set to In";
    private String outMenuTitle = "Set to Out";
    private boolean flag = false;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        // Create your menu...

        this.menu = menu;
        return true;
    }

    private void updateMenuTitles() {
        MenuItem menuItem = menu.findItem(R.id.bedSwitch);
        if (flag) {
            menuItem .setTitle(outMenuTitle);
        } else {
            menuItem .setTitle(inMenuTitle);
        }
    }

}