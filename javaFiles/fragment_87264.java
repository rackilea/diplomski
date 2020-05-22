private MyCustomMenuInstance mMenuInstance;

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);        
    setContentView(R.layout.main);

    mMenuInstance = new MyCustomMenuInstance();
}  

@Override
public boolean onPrepareOptionsMenu(Menu menu) {
    mMenuInstance.onPrepareOptionsMenu(menu);
    return super.onPrepareOptionsMenu(menu);
}

@Override
public boolean onOptionsItemSelected(MenuItem i) {
    mMenuInstance.onOptionsItemSelected(i);
    return super.onOptionsItemSelected(i);
}