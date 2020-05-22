Button send = (Button) findViewById(R.id.send);
    send.setOnClickListener(new OnClickListener() {         
        @Override
        public void onClick(View v) {
            if (mAllowSave) {
                mAllowSave = false;
                showDialog(SAVING_DIALOG);
                mSaveFileThread = new SaveFileThread(handler);
                mSaveFileThread.start();
            }
        }
    });