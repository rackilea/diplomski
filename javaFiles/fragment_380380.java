public static final int TYPE1 = 1;  // use a better name ...
public static final int TYPE2 = 2;
public void handleMessage(Message msg) {
    switch(msg.what) {
         case TYPE1: polldata=(ArrayList<PollQuestion>) msg.obj; break;
         case TYPE2: ...
      }
}