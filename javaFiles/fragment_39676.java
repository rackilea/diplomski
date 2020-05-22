Thread 1:
  Thread myClass = new Thread(new MyClass(someList));
    listBonds.set(someList);
  myClass.start(); 
Thread 2: (MyClass)
  listBonds.get() --- A new thread is requesting the threadlocal variable and hence its null