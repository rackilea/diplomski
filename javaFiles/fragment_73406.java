long endTime = System.currentTimeMillis() + 300000; //After 5 min leave while loop

while (System.currentTimeMillis() < endTime 
  && main.myencryption0 == null
  && main.myencryption1 == null)
{
  prepareEncoding(letter); 

  try {
    Thread.sleep(1);
  } catch (InterruptedException ex) {
    ex.printStackTrace();
  }  
}

if (main.myencryption0 != null && main.myencryption1 != null) {
  prepareToGoal(letter);
} else {
  reallyFail(); // OK - give up, drop the ball
}