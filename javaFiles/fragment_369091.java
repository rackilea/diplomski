// Initialize myAsync
myAsync task = new myAsync();

// This will do work for some period of time, this statement DOES NOT 'block'
// till myAsync completes, it will run it in the background
task.execute(params);

// This will return null because by the time you get here, task.execute most
// likely hasn't finished yet.
task.getResultList();