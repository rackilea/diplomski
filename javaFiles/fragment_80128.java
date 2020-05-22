public class Utils{

private Context _context;

public Utils(Context context){
    this._context = context;
}

public void menuSwitch(int item) {
       switch (item) {
            case R.id.menu_one:
                _context.startActivity(new Intent(_context.getApplicationContext(),
                        MainActivity.class));
            case R.id.menu_two:
                _context.startActivity(new Intent(_context.getApplicationContext(),
                        MessageActivity.class));
            case R.id.menu_three:
                _context.startActivity(new Intent(_context.getApplicationContext(),
                        LocateActivity.class));
            case R.id.menu_four:
                _context.startActivity(new Intent(_context.getApplicationContext(),
                        AboutActivity.class));
    }
}
}