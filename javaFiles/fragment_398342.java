public LocalTime getTimeStart(){
      return timeStart;
}   

public String getTimeStartAsString(){
      return timeStart == null ? "" : timeStart.toString("hh:mm");
}