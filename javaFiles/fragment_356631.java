MediaPlayer mediaPlayer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab4makesounds, container, false);
        Button btnOne = (Button) view.findViewById(R.id.YourButtonId);

       btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                  if(mediaPlayer != null) {
                     mediaPlayer.stop();
                     mediaPlayer.release();
                     mediaPlayer = null;
                  }

                  mediaPlayer = MediaPlayer.create(getActivity(), R.raw.your_sound);
                  mediaPlayer.start();
            }
        });
        return view;
    }
}