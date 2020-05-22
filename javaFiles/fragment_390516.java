// this should be declared elsewhere because if it's local to bookSeat it will be lost
// and reinitialized upon each call to bookSeat
Seat[][] book = new Seat[12][23];

// and this is how, after previous declaration, the function will be called
Seat theBookedSeat = bookSeat(book);

// Okay, now we have selected a random seat, mark it as booked, assuming Seat has a 
// method called book:
theBookedSeat.book();


// and this is the modified function.  Note also that function in Java by convention
// start with a lowercase letter.
public static Seat bookSeat(Seat[][] x){
    if (x != null){  
        // using Random as shown by chm052
        Random r = new Random();
        // need to pick a random one in each dimension
        book = x[r.nextInt(x.length)][r.nextInt(x[0].length)];  
    }
    return book;  
}