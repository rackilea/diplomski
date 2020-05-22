Stream stream = new Stream ("localhost", 5000);
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
if (iHaveAGoodDay){
    stream.writeObject (new IamHappy ());
}else{
    stream.writeObject (new IwillHackYou ());
}
Thread.sleep (10000);
stream.close ();