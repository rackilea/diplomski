String line="FX1511237205/162370000000933.00/1/Train,Train.Time:1:1=MysoreExp,Station:1:1=Cantonment,Carts.AC:1:1=05,Currency.Transaction:1:1=INR,Station.Destination:1:1=Bangalore City,Total.Fare:1:1=35.00,Date.Booked:1:1=20150422,Date.Travel:1:1=20160517,Seat.Remaining:1:1=4,Food:1:1=Veg North }North Indian Food  &amp;{at Station Bangalore city,Accomodation:1:1=Hotel Booking }Hotel Booking is not &amp;{done,Travel:1:1=Cab}Destination  &amp;{Hotel  Capitol,No.Passenger:1:1=5,Booking:1:1=Success";   
String pattern="(\\w+:\\d+:\\d+\\=[\\w|\\s]+\\}[\\w|\\s|\\&|\\;]+\\{[\\w|\\s]+\\,)";
Pattern r = Pattern.compile(pattern);    
Matcher m = r.matcher(line);

if (m.find()) {
    System.out.println(m.group());
    while (m.find( )) {
        System.out.println(m.group());      
    }
}
else {
    System.out.println("NO MATCH"); 
}