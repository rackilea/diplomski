/*
         * Ensure that unless pool is stopping, this thread
         * does not have its interrupt set. This requires a
         * double-check of state in case the interrupt was
         * cleared concurrently with a shutdownNow -- if so,
         * the interrupt is re-enabled.
         */
        if (runState < STOP &&
            Thread.interrupted() &&
            runState >= STOP)
            thread.interrupt();