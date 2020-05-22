public List GetfromServer(){
    try {
        url1=new URL("http://myipaddress/videos/");
        ApacheURLLister lister = new ApacheURLLister();
        serverDir.addAll(lister.listAll(url1));
        Log.d(TAG,serverDir.toString());
    }
    catch (Exception e){
        e.printStackTrace();
    }
    return serverDir;
}