RadioGroup rb = (RadioGroup) findViewById(R.id.your_Radio_group_id);
    rb.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                case R.id.rbTerrorist:
                    // to task                                         
                    break;
                case R.id.rbCounterTerrorist:
                    // to task                                         
                    break;
            }
        }

    });