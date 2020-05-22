public class Game extends Activity implements OnTouchListener{
    GameView gv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gv = new GameView(this);
        setContentView(gv);

        gv.setOnTouchListener(this);
    }
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        // TODO Auto-generated method stub
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            int x = event.getX();
            int y = event.getY();
            System.out.println("Touched view at X: " + X + " Y: " + Y );
        }
        return false;
    }

}