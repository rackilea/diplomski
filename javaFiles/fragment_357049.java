public void printThreads(PrintWriter wtr) {
    ThreadGroup     root;

    totGroups=0;
    totThreads=0;

    for(root=Thread.currentThread().getThreadGroup(); root.getParent()!=null; root=root.getParent()) {}
    wtr.println("Thread Dump:");
    printThreadGroup(wtr,root,"  ");
    wtr.println("  -- Total Groups: "+totGroups+", Total Threads: "+totThreads);
    }

public void printThreadGroup(PrintWriter wtr, ThreadGroup grp, String pfx) {
    try {
        Thread[]        thds;
        ThreadGroup[]   grps;

        totGroups++;
        wtr.println(pfx+"Group: "+grp.getName()+", "+(grp.isDaemon()?"Daemon":"Normal")+", "+(grp.isDestroyed()?"Destroyed":"Alive")+", "+grp.getMaxPriority());
        thds=new Thread[grp.activeCount()];
        grp.enumerate(thds,false);
        Arrays.sort(thds,THREAD_SORTER);
        for(int xa=0; xa<thds.length && thds[xa]!=null; xa++,totThreads++) {
            Thread          thd=thds[xa];
            wtr.println(pfx+". - ["+thd.getName()+", "+(thd.isDaemon()?"Daemon":"Normal")+", "+(thd.isAlive()?"Alive":"Not Started or Dead")+", "+thd.getPriority()+"]");
            }

        grps=new ThreadGroup[grp.activeGroupCount()];
        grp.enumerate(grps,false);
        Arrays.sort(grps,GROUP_SORTER);
        for(int xa=0; xa<grps.length && grps[xa]!=null; xa++) {
            printThreadGroup(wtr,grps[xa],(pfx+". "));
            grps[xa]=null;
            }
        }
    catch(Throwable thr) {
        wtr.println("  Cannot print threads ("+thr+")");
        }
    }

public void printStacks(PrintWriter wtr) {
    wtr.println("Thread Stack Traces:");
    try { javaMx.printStacks(wtr); } catch(Throwable thr) { wtr.println("  Cannot print stacks ("+thr+")"); }
    wtr.println("  --");
    }