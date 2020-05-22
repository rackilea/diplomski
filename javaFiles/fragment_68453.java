alarmEkleBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            hour = timePicker.getHour();
            minute = timePicker.getMinute();

            listener.alarmBilgisiGetir(hour, minute, quantity);
            dismiss();
        }
    });