public class ActivityClass extends Activity{
    private RelativeLayout main;
    private RelativeLayout newLayout;

    protected void onCreate(Bundle b){...}
    ...

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case R.id.action_hide:
            main = (RelativeLayout) findViewById(R.id.atraccion_layout);
            newLayout= (RelativeLayout) View.inflate(this, R.layout.newLayout, null);     
            main.addView(newLayout);
            return true;
        }
        default:
            return super.onOptionsItemSelected(item);
    }

    public void close(View v){
        main.removeView(newLayout);
        main.forceLayout();
    }  
}