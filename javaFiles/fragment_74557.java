public void recordBtnClick(View v){
    final ToggleButton touchToRecord = (ToggleButton)findViewById(R.id.tBtn1);
    final ImageButton recBtn = (ImageButton) findViewById(com.whizzappseasyvoicenotepad.R.id.recButton);
    if (touchToRecord.isChecked() == false)
    {
        if (recorder == null)
        {
            recBtn.setImageResource(com.whizzappseasyvoicenotepad.R.drawable.record_btn_pressed);
            chTimer.start();
            chTimer.setTextColor(Color.GREEN);
            startRecording();
        }
        else if (recorder != null)
        {
            recBtn.setImageResource(com.whizzappseasyvoicenotepad.R.drawable.record_btn);
            chTimer.stop();
            stopRecording();
            nameAlert();
        }
    }
    else
    {
        //DO NOTHING
    }
}