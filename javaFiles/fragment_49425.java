List<DateClassObject> myList = new ArrayList<>();

Calendar from =  // get the from date from user and store here
Calendar to = // get the to date from user and store here

//to check 'from' is after 'to'

if(from.after(to)){
    // Do your operation
}

for(int j = 0; j < myList.size(); j ++){ //Note. you've written, for(int j = 1; j <= myList.size(); j ++) , ArrayList index start from 0. you'll miss the first element. I hope it helps you in the future

    Calendar dateFrom = myList.get(j).dateFrom;
    Calendar dateTo = myList.get(j).dateTo;

    if(isSameDay(from, dateFrom) && isSameDay(to, dateTo)){ // checking same period allready exists
        // if it exists Do operation
    }
    else{
        // if it does not exists, I assume, you want to add DateClassObject to your arrayList
        myList.add(new DateClassObject(from, to));
    }
}

public boolean isSameDay(Calendar cal1, Calendar cal2) {
    if (cal1 == null || cal2 == null) {
        throw new IllegalArgumentException("The dates must not be null");
    }
        return (cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH) &&
            cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
            cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH));
}

public class DateClassObject {

    public Calendar dateFrom;
    public Calendar dateTo;

    public Date difference;

    public DateClassObject(Calendar dateFrom, Calendar dateTo) {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }
}