LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            winView = inflater.inflate(R.layout.win, null);
            submit = (Button) winView.findViewById(R.id.submitScore);

            submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {