AlertDialog.Builder builder = new AlertDialog.Builder(GameScreen.this);
    LayoutInflater inflater = GameScreen.this.getLayoutInflater();
    View v = inflater.inflate(R.layout.betvalue, null);
    builder.setView(v)
           .setPositiveButton  ... 
           .setNegativeButton ...
           .setTitle("Enter bet amount");
    SeekBar sbBetVal = (SeekBar)v.findViewById(R.id.sbBetVal);
    tvBetVal = (TextView)v. findViewById(R.id.tvBetVal);
    sbBetVal.setMax(100);
    sbBetVal.setProgress(0);
    sbBetVal.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress,
                boolean fromUser) {
            // TODO Auto-generated method stub
            tvBetVal.setText(String.valueOf(progress));
        }
    });

    builder.create();
    builder.show();