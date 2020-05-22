@Override
    public void run() {
        try {

            while (queue.size() != 0) {
                String msg = getObj.getMsg();
                String[] result = msg.split("\\s");
                String msg2 = result[0];

          runOnUiThread(new Runnable() {

                @Override
                public void run() {
                if(msg2.equals("ON")){
                    txt.setText("ON");
                    //turnOn();
                }
                else if(msg.equals("OFF")){
                    txt.setText("OFF");
                   // turnOff();
                }
              }
             }
            }
            if (queue.size() == 0) {
                Thread.sleep(1000);
                run();
            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        }