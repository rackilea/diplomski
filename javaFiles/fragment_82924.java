boolean beenPrinted = false;

if (blob.getRect().intersects(screenRects.get(0)) && !beenPrinted){
   println("INSIDE_REGION1"+millis());
   String filename = dataPath("bubble.mp3");
   SamplePlayer sp = new SamplePlayer(ac,            
                                      SampleManager.sample(filename));
   ac.out.addInput(sp);
   beenPrinted = true;
}