private class CalculatePI(Byte[] resume) implements Runnable{
    public void Run(){
       while(!Thread.interrupted()) { //###
          resume=resumeCalculating(resume);
       }
    }
}
Thread calculator= new Thread(new CalculatePI(Byte[] resume)); 
calculator.run(); //###
//...
//And now I want to kill calculator
calculator.interrupt(); //### sends the signal
//...
calculator.join(); //### actually waits for it to finish