sendBroadcastBool = false;
button.setOnClickListener(new OnClickListener(){
        public void onClick(View v) {
            // If broadcast not sent yet
            if (!sendBroadcastBool) {
                startBroadcastLoop();
                sendBroadcastBool = true;
            }
            else {
                stopBroadcastLoop();
                sendBroadcastBool = false;
            }
        }
    });