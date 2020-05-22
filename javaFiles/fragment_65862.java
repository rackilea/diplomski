public void addToList(String newAdd, CallableInterface callback)
{   
    names.add("BMW");
    names.add("DODGE");

    t.schedule(new TimerTask() {
        @Override
        public void run() {     
            names.add(newAdd);
            callback.callBackMethod();
        }
    }, 5000);
}