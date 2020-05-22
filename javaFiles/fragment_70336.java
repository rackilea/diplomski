alertDialog.setButton2("No",new DialogInterface.OnClickListener(){
    public void onClick(DialogInterface dialog, int which){

        dialog.dismiss();

        new CountDownTimer(3000,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                textView.setText(""+(millisUntilFinished%1000));
            }

            @Override
            public void onFinish() {
                textView.setVisibility(View.GONE);
                GamePanel.thread.setRunning(true);
            }
        };

        reurn;
    }
});