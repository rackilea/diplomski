public void run(long ptr)
{
    this.ptrToMapReduceBridge = ptr;
    //do stuff
}
@Override
public void onReceiveResult(double[] results) {
   this.results = results;
   runCompletedCallback(this.ptrToMapReduceBridge);