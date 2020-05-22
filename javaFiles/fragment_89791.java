call order:  
1. java.util.concurrent.ScheduledThreadPoolExecutor#scheduleAtFixedRate 
2. java.util.concurrent.ScheduledThreadPoolExecutor#delayedExecute   
3. java.util.concurrent.ThreadPoolExecutor#ensurePrestart
            /**
             * Same as prestartCoreThread except arranges that at least one
             * thread is started even if corePoolSize is 0.
             */
            void ensurePrestart() {
                int wc = workerCountOf(ctl.get());
                if (wc < corePoolSize)
                    addWorker(null, true);
                else if (wc == 0) //here's your case
                    addWorker(null, false);
            }