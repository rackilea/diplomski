toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if(b){
                tvText.setEnabled(true);
                tvText.setText("enabled");
                tvText.setAlpha(1);
            }else{
                tvText.setText("disabled");
                tvText.setAlpha(0.4f);
                tvText.setEnabled(false);
            }
        }
    });