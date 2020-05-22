private void myGenericMethod(Runnable runnable){
    common task1;
    common task2;
    //consider checking if runnable != null to avoid NPE
    runnable.run();
}