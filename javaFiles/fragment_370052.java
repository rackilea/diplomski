class Post .... {
    ...

    public String getTimeDate(long timestamp) {
        try {
            DateFormat dateFormat = DateFormat.getDateTimeInstance();
            Date netDate = (new Date(this.timestamp));
            return dateFormat.format(netDate);
        } catch (Exception e){
            return new RuntimeException(e);
        }
    }

}