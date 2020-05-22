private Menu myMenu;
public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(fab_menu, menu);
    this.myMenu = menu;
    while (!isHeDead()){
        return true;
    }
    return false;
}