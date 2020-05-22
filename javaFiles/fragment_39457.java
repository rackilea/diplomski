new CountDownTimer(600000, 60000) {//CountDownTimer(edittext1.getText()+edittext2.getText()) also parse it to long

             public void onTick(long millisUntilFinished) {
                  System.out.println("Your message on every minute");
              //here you can have your logic to set text to edittext
             }

             public void onFinish() {
                  System.out.println("Your message after 10 minute");
             }
            }
            .start();