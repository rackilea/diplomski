@Override
public void run() 
{
    f.setVisible(true);
    timer.start();
    try {
        doneSignal.await();
    } catch (InterruptedException ex) {}//Logg this or something. Shouldn't really ever happen. 

}