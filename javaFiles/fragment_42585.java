public void demo() {
        String message1, message2;
        message1 = "Klockan är " + getHour() + ":" + getMinute() + ":" +            getSecond();    
        JOptionPane.showMessageDialog(null, message1);  
        message2 = toString();      
        JOptionPane.showMessageDialog(null, message2);
    }

    public int getHour() {
        return Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
    }

    public int getMinute() {
        return Calendar.getInstance().get(Calendar.MINUTE);
    }

    public int getSecond() {
        return Calendar.getInstance().get(Calendar.SECOND);
    }

    public String toString() {
        return getHour() + ":" + getMinute() + ":" + getSecond() + " ";
    }