if(SelectedLine == "REDLINE")
        {
            loadData("red");
            Log.d(TAG,"loaded Red Data");
            redNotificationSwitch= (Switch) findViewById(R.id.red_switch);
            redNotificationSwitch.setVisibility(View.VISIBLE);
            updateView(redNotificationSwitch);
            redNotificationSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    saveData("red",isChecked);
                    SelectedLineNotifications = "REDLINE";
                    notificationSwitchMethod(redNotificationSwitch);
                }
            });

        }