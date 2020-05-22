public class Dates {
    public LocalDate date;
    public int value;

    public Dates(LocalDate date, int value){
        this.date = date;
        this.value = value;
    }

    public LocalDate getDate(){
        return this.date;
    }

    public int getValue(){
        return this.value;
    }
}