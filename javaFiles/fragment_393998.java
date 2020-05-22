try {
   /*
    * Set class Variable so that I can dynamically change the Activity
    * to be called with intent.
    * Testing the variable with Level001Activity, but app keep crashing
    * when startBtn is pressed with stack error I post below
    */
    classVariable = Class.forName("com.ed.pieces.Level001Activity");
} catch (ClassNotFoundException e) {
    e.printStackTrace();
}