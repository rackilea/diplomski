public class TestMenu {

    private final PopupMenu popupMenu;

    public TestMenu(final Activity activity, View anchor) {
        popupMenu = new PopupMenu(activity, anchor);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.one:
                        Intent vista = new Intent(activity, openCamera.class);
                        activity.startActivity(vista);
                }
                return true;
            }
        });
    }

    public void show() {
        popupMenu.show();
    }
}