public void ....{
    //Interrupt code
    tostop = true;
    thread1.sleep(300);  // Give the thread sometime for cleanup
    //Use System.exit(0), if the thread is in main function.
}