// The callback interface
interface MyCallback {
void callbackCall(List<String> response);
}

// The class that takes the callback
class Worker {
MyCallback callback;

void onEvent(List<String> response) {
  callback.callbackCall(response);
   }
}

// Option 1: MainActivity or where the list is

class Callback implements MyCallback {
  void callbackCall() {
   // callback code goes here
   // update your adaptor 


   }
 }

worker.callback = new Callback();

// Option 2:

worker.callback = new MyCallback() {

void callbackCall(List<String> results ) {
  // callback code goes here

   }
};