Receiver receiver = new Receiver (5000, new Receiver.OnNewSocketListener (){
    @Override
    void onNewSocket (Stream stream){
        stream.setOnCloseStreamListener (new Stream.OnCloseStreamListener (){
            @Override
            void onCloseStream (){
                //Stream is closed automatically, don't need to call close()
                //Do something
            }
        });
        stream.setOnReadObjectListener (new Stream.OnReadObjectListener (){
            @Override
            void onReadObject (Object obj){
                //Do something with obj
                if (obj.isDoingSomeMaliciousActivities ()){
                    stream.close ();
                }else if (obj.isDoingGoodStuff){
                                    stream.writeObject (new GoodStuff ());
                            }
            }
        });
        stream.startReading ();
    }
});
receiver.start ();
Thread.sleep (10000);
receiver.stop ();