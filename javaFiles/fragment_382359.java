// in the doInBackground of your AsyncTask
while (!Terminated) 
{
    while (!Terminated && myQueue.isEmpty()) 
    { 
        Thread.sleep(250);
    }
    if (Terminated) break;
    QueueItem qItem = myQueue.poll();
    if (qItem != null)
    {
        DatagramPacket toForward = new DatagramPacket(qItem.data, qItem.data.length,InetAddress.getByName(qItem.dstIP, qItem.dstPort));
        uniSocket.setBroadcast(false);
        uniSocket.send(toForward);
    }
}