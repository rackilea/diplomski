class A{
      private B b = new B();
      public static AtomicInteger count = new AtomicInteger(0);
      public void restore(){
        b.restoreTask();
      }
    }

    class B{
      public void restoreTask(){
        int taskcount = somenumber;
        A.count.addAndGet(taskcount);
        for(int i = 0; i<taskcount; ++i){
          do something to all tasks
        }
      }
    }