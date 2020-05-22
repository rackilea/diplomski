private class MidiSender extends Thread
{
    private boolean _raiseStop = false;
    private Object _sendLock = new Object();

    private LinkedList<ByteBuffer> _outputQueue = new LinkedList<ByteBuffer>();

    public void queue(ByteBuffer buffer)
    {
        synchronized(_sendLock)
        {
            _outputQueue.add(buffer);
            // Thread will most likely be paused (to save CPU); need to wake it
            _sendLock.notify();
        }
    }

    public void raiseStop()
    {
        synchronized (this)
        {
            _raiseStop = true;
        }

        //Thread may be blocked waiting for a send
        synchronized(_sendLock)
        {
            _sendLock.notify();
        }
    }

    public void run()
    {
        while (true)
        {
            synchronized (this)
            {
                if (_raiseStop) 
                    return;
            }

            ByteBuffer currentBuffer = null;
            synchronized(_sendLock)
            {
                if(!_outputQueue.isEmpty())
                    currentBuffer =_outputQueue.removeFirst(); 
            }

            while(currentBuffer != null)
            {
                // Here's the synchronous equivalent (timeout is a reasonable 0.1s):
                int transferred = _connection.bulkTransfer(_outPort, currentBuffer.array(), currentBuffer.position(), 100);

                if(transferred < 0)
                    Log.w(_tag, "Failed to send MIDI packet");

                //Process any remaining packets on the queue
                synchronized(_sendLock)
                {
                    if(!_outputQueue.isEmpty())
                        currentBuffer =_outputQueue.removeFirst();
                    else
                        currentBuffer = null;
                }
            }

            synchronized(_sendLock)
            {
                try
                {
                    //Sleep; save unnecessary processing
                    _sendLock.wait();
                }
                catch(InterruptedException e)
                {
                    //Don't care about being interrupted
                }
            }

        }           
    }
}