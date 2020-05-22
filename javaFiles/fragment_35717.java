cordova.getActivity().runOnUiThread(new Runnable(){
 public void run() {

                textView.setText("Cordova Hello World"); 

                callbackContext.success(); 

                // Thread-safe. 

        } });