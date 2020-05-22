// Consumer
this.lock.lock();
Log.d("websocket", "Sender acquired lock");
try
{
    Log.d("websocket", "Sender waiting for message from server");
    while( result == null )   // CHANGE HERE
        resultReady.await();
    Log.d("websocket", "Sender waking up");
    return this.result;

} catch (InterruptedException e)
{
    e.printStackTrace();
}
finally {
    this.lock.unlock();
}