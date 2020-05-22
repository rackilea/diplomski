private void writeObject(ObjectOutputStream oos) throws IOException {
    oos.defaultWriteObject();
    if (null != checkInDate)
        oos.writeUTF(new java.text.SimpleDateFormat("yyyy-MMM-dd hh:mm").format(checkInDate));
}

private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException { 

    ois.defaultReadObject();
    try {
        setCheckInDate(new java.text.SimpleDateFormat("yyyy-MMM-dd hh:mm").parse(ois.readUTF()));
    } catch (ParseException e) {

    }
}