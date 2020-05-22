for (MyObj instance : allMyObjs) {
     instance.getAStoppableThreadObject.start();

     System.out.println("Thread started. Waiting til finished..");
     instance.getAStoppableThreadObject.join(); //will wait until its finished
     System.out.println("Thread has finished");
}