Runnable nextThingToDo = getNextTaskFromQueue(); 
nextThingToDo.run();
// inside above "run"... whatever code path leads to turnend()
    if (leftover == 0) {
        housenumber = 1;
        Runnable r = construct();// it's only a reference to a `Runnable` object, nothing executes here
        t = new Timer(r, 500, true);
        // inside Timer
            handler.postDelayed(task, 500); // task is now in the queue
    }
    //code 2 -- it actually runs now.
// whatever else is in your code on the way out from "turnend()"

// ... things happen, 500ms passes

Runnable nextThingToDo = getNextTaskFromQueue(); // this is the `task` object
nextThingToDo.run();
// inside this "run"
    if (!paused) {
        runnable.run (); // this is the `r` object
        // inside task
           {
            // code1 -- running ~ 500ms after code2
            if (housenumber == 8) {
                t.stopTimer();
            }
          }