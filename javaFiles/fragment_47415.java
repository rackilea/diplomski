void runFunction()
{
    Class1 thePlot = new Class1;
    Thread t1=new Thread() {
       public void run() {
           Class1 thePlot = new Class1;
           thePlot.waitForFigures();
           }
    }
    Thread t2=new Thread() {
       public void run() {
           Class1 thePlot = new Class1;
           thePlot.waitForFigures();
           }
    }
    thePlot.waitForFigures();
    t1.start();
    t2.start();

    //your java code

    thePlot.EmptyCode();
    thePlot.waitForFigures();
}