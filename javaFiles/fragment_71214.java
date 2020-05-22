public volatile boolean getPressed;

private Object lock = new Object(); // added lock for wait/notify coordination
private String Data; //changed scope to make it accessible in getMessage()

Jsend.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {

        synchronized(lock){
            Data = Jusertxt.getText(); // no more a local variable, it's an instance attribute now, see declaration above
            Jusertxt.setText(null);
            System.out.println(Data);
            getPressed=true;
            lock.notify(); // notify client that user performed action
        }
    });
}

public boolean getPressed(){
    synchronized (lock) {
        try {
            lock.wait(); // wait for user to perform action...
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    return getPressed; // ...then return value (I guess getPressed will always be true at this point)
}

public String getMessage(){ // call this in TCPClient instead of pro.Jusertxt.getText()
    return Data;
}