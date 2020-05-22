FutureTask<Integer> coWorker = new FutureTask<>(/* callable wrapping sub-task*/);
executor.execute(coWorker);

// proceed in the task’s sequence

if(executor.remove(coWorker)) coWorker.run();// do in-place if needed
subTaskResult=coWorker.get();

// proceed