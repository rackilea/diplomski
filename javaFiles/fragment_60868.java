ProcessorCoG CrossOpg = new ProcessorCoG(timevalue);//extends Thread class
            ProcessorCordm CrossOp = new ProcessorCordm(timevalue);//extends Thread class
            ProcessorCordm CrossOp2 = new ProcessorCordm(timevalue);//extends Thread class
            MutateGb MutGb = new MutateGb(timevalue);//extends Thread class
            MutateRdm MutRdm = new MutateRdm(timevalue);//extends Thread class
            MbsRdm MbsR = new MbsRdm(timevalue);//extends Thread class
            ExecutorService executor = Executors.newFixedThreadPool(6);
            executor.submit(MutGb);
            executor.submit(MutRdm);
            executor.submit(CrossOp);
            executor.submit(CrossOp2);
            executor.submit(CrossOpg);
            executor.submit(MbsR);