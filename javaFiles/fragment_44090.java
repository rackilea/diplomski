public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {

    View view =  inflater.inflate(R.layout.fragment_fragment_a, container, false)
    ImageButton one1 = (ImageButton) view.findViewById(R.id.imageButton1);
    one1.setOnTouchListener(new OnTouchListener() {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            // TODO Auto-generated method stub
            int resID =   R.raw.a;
            switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //mp.setLooping(true);

                if (mp != null) {
                     mp.release();
                  }
                  // Create a new MediaPlayer to play this sound
                  mp = MediaPlayer.create( getActivity(), resID);
                  mp.start();
                break;

            case MotionEvent.ACTION_UP:
                mp.stop();
                break;
            }
            return true;
        }
    });
    return view;


}