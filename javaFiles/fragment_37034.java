@Override
void onActivityResult(...) {
   ....
   if (count <= NUMBER_OF_CALLS) {
       delayedCallHandler.sendMessageDelayed(
                    delayedCallHandler.obtainMessage(0, "tel:" + edit_text_value), // msg.obj = the number to call
                    secondz); // 50 seconds
       count++;
   }
   ....
}