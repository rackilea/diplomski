@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);     

        editText1.setOnTouchListener(listener);
        editText2.setOnTouchListener(listener); 

    }


OnTouchListener listener = new OnTouchListener() {      
        @Override
        public boolean onTouch(View v, MotionEvent event) {

            switch (v.getId()) {
            case R.id.editText1:

                break;

             case R.id.editText2:

                break;

            default:
                break;
            }           
            return false;
        }
    };