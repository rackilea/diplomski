//Boilerplate code for SWT Shell
   //Event loop modified in our case
   boolean readAndDispatch;
        while (!shell.isDisposed()) { //UI Thread continuously loop in Processing and waiting for Events until shell is disposed.
            try {
                readAndDispatch = shell.getDisplay().readAndDispatch(); // reads an Event and dispatches, also returns true if there is some work else false.
                if (!readAndDispatch) { //There is no work to do, means, System is idle
                    timer.schedule(worker, delay); // So, schedule a Timer which triggers some work(lock or logout code) after specified time(delay)
                    shell.getDisplay().sleep(); 
                } else{
                    timer.reschedule(delay); //This means System is not idle. So, reset your Timer
                }
            } catch (Throwable e) {
                log.error(ExceptionUtils.getStackTrace(e));
                MessageDialog.openError(shell, "Error !!", ExceptionUtils.getRootCauseMessage(e));

            }
        }