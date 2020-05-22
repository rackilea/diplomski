public String getCurrenttime(){

    String time= this.get(YEAR)+"-"+(this.get(MONTH)+1)+"-"+
            this.get(DATE)+"-"+this.get(HOUR_OF_DAY)+"-"+this.get(MINUTE)+"-"+this.get(SECOND);
    return time;
}