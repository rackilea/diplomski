if(isServiceStarted){
setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

}
if(isServiceEnded){
//flip to original view
setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
}