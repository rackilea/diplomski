public class MyService extends Service {

 int counter;
 @Override
 public void onCreate() {
  counter = size ;
  for(int i=0;i<size;i++){
    /....Multiple POST Requests..../

    OnResponse: 
    counter-- 
    if(counter ==0){ 
      execute unregisterReceiver();
      }

   }

 }

 @Override
 public void onDestroy() {

   }
 }