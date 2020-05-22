button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            AsynTaskTest asynTaskTest = new AsynTaskTest(v.getContext() , progressBar);
            asynTaskTest.execute();
        }
    });