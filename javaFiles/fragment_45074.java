public class Game extends Activity {

    private Container mainLayout;

        @Override
        protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.game_activity);

            mainLayout = (Container) findViewById(R.id.mainLayout);
    }

    private static class Container extends LinearLayout {

        public Container(Context context) {
            super(context);
        }

     //... code
     //... code
    }
}