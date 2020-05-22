void onResume(){
   super();
   if(isServiceOn){
      changeToLandscape()
   }
   else{
     changeToPro()
   }
}
void onPause(){
       super();
       if(isServiceOn){
          changeToLandscape()
       }
       else{
         changeToPro()
       }
    }