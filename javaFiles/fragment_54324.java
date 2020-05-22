class Myclass {

    //Static to make it possible to synchronize between instances of Myclass
    static Date lastDate;

    Date getUniqueTimeStamp() {
        synchronized (Myclass.lastDate) {
            Date newDate = new Date();
            if (newDate.getTime() <= Myclass.lastDate.getTime()) {
                newDate.setTime(Myclass.lastDate.getTime()+1);
            }
            Myclass.lastDate.setTime(newDate.getTime());
            return newDate;
        }
    }
}