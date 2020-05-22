public class CallLogEntry {
  String number;
  String type;
  String date;
  String duration; //this should ideally be of type Long (milliseconds)  

      public CallLogEntry(){
       //do stuff if necessary for no-params constructor
      }

      public CallLogEntry(String number, String type, String date, String duration){
        this.number = number;
        this.type = type;
        this.date = date;
        this.duration = duration;
      }

      //getters and setters go here..
      getNumber(){ return this.number;}
      setNumber(String number){ this.number = number;}
      //...the rest of them...
    }