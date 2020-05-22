public void printData(String str){
    final String character = "-----------------\nCOMBO\n-----------------\nCOMBO\n-----------------\n\n-----------------\nSome more data...\n-----------------\nAnother Line\n-----------------\n";
    setCharSize(01);
    startPage(50004);
    if(character != null){
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                byte[] array = character.getBytes();
                ByteBuffer output_buffer = ByteBuffer.allocate(array.length);
                UsbRequest req = new UsbRequest();
                req.initialize(mConnection, ep);
                req.queue(output_buffer, array.length);
                if(mConnection.requestWait() == req){
                    output_buffer.clear();
                    endPage();
                } else{
                    Log.d("USB", "No USBRequest received");
                }
            }
        });
        t.start();
    }
}