Button btnCap = (Button) findViewById(R.id.btnTakeScreenshot);
    btnCap.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            try {
                CaptureMapScreen();
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }

        }
    });