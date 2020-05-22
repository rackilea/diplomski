Threading t1 = new Threading(s,'a');
      Threading t2 = new Threading(s,'b');
      Threading t3 = new Threading(s,'c');
      t1.start();
      t1.join();
      t2.start();
      t2.join();
      t3.start();