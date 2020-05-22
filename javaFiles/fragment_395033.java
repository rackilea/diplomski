// wokerThread wr=new wokerThread(sc,mQConnection); --> move this into the loop
        // wr.init(); --> move this into the loop
        Thread[] worker=new Thread[2];
        for(int i=0;i<worker.length;i++)
        {
            wokerThread wr=new wokerThread(sc,mQConnection); // --> moved into the loop
            wr.init(); // --> moved into the loop
            worker[i]=new Thread(wr,""+i);
            worker[i].start();
        }