try {
        Thread t1 = new Thread(new Runnable(){
            public void run(){
                String response = null;
                try {
                    response = VisionClient.send(context, photoFile, mCurrentPhotoPath);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                txtComputerVisionTextResult.setText(response);
                Toast toast = Toast.makeText(context, "response = " + response, Toast.LENGTH_LONG);
                toast.show();
            }
        }
        );
        t1.start();