public void startCounterDown(View view){

    CountDownTimer cuentaRegresiva = new CountDownTimer(100000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            long segundos = millisUntilFinished/1000;
            long minutos;
            if (segundos>= 60) {
                minutos = segundos / 60;
                segundos = segundos - minutos * 60;
                if (minutos > 9) {
                    if (segundos > 9) {
                        timeView.setText(String.valueOf(minutos) + ":" + String.valueOf(segundos));
                    } else {
                        timeView.setText(String.valueOf(minutos) + ":0" + String.valueOf(segundos));
                    }
                } else {
                    if (segundos > 9) {
                        timeView.setText("0" + String.valueOf(minutos) + ":" + String.valueOf(segundos));
                    } else {
                        timeView.setText("0" + String.valueOf(minutos) + ":0" + String.valueOf(segundos));
                    }
                }
            } else {
                if (segundos>9){
                    timeView.setText("00:" + String.valueOf(segundos));
                } else {
                    timeView.setText("00:0" + String.valueOf(segundos));
                }

            }
        }

        @Override
        public void onFinish() {
            timeView.setText("Time out!");
            mplayer.start();

        }
    }.start();


}