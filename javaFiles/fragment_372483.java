public first(){
    sec=new second(); // creates an instance of second - X = 100, Y = 100
    t=new third(); // creates an instance of third, which creates a different instance of 
                   // second and updates X and Y to 200
    sec.update(); // prints the original instance of second - X and Y still contain 100
}