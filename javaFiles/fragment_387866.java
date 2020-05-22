soundnotify.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            // TODO Auto-generated method stub
            if (isChecked) {
                // Sound Notifications is enabled
                soundnotify.setSoundEffectsEnabled(true);
            } else {
                // Sound Notifications is disabled
                soundnotify.setSoundEffectsEnabled(false);
            }
        }
    });