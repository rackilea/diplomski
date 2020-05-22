toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    setColor(Color.GREEN, true);
                } else {
                    setColor(Color.RED, false);
                }
            }
        });