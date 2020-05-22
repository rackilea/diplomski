boolean shouldStop = false;

...
while (!shouldStop){
  if(FlashOn){
    ...//do SOS stuff
  }
}

...
public void endSOS(){
  shouldStop = true;
}