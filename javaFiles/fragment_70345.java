Button rollButton=findViewById(R.id.rollButton);
TextView resultTexView=findViewById(R.id.resultsTextView);
SeekBar seekBar=findViewById(R.id.seekBar);

button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int rand = Random().nextInt(seekBar.progress) + 1
    resultsTextView.setText(rand.toString());
            }
        });