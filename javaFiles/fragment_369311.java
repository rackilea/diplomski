public class TwoDArray {

  public static void main(String[] args)
  {      
    Cars[][] cars; // declaring my 2D array.

    cars = new Cars[4][]; // making the x axis 4 cars wide.

    // now we will step along the x axis and create a Cars array in each slot.
    for ( int a = 0; a < cars.length; a++) // cars.length = how wide.
    { 
        cars[a] = new Cars[3]; // creating a new Cars[] in each slot of our 2D Car array @ position a.
                               //cars[a] = new 1D Cars array in slot a, length of 3.
    }

    // Note that we could have also created our array like this.
    // Cars[][] cars = new Cars[4][3];


    for ( int x = 0; x < cars.length; x++) //stepping along the x axis. cars.length = how wide.
    {   //every time we step thru x we will execute this next loop.
        for ( int y = 0; y < cars[x].length; y++) // stepping along the y axis. cars[x].length = how long.
        { // this loop will cycle through the y axis each time we increment x
            cars[x][y] = new Cars( 2014, "someAudi", x + " " + y ); // creating a new car(s) @ x,y position.
        }
    }

    // now to just print them.

    for ( int x = 0; x < cars.length; x++) //stepping along the x axis again.
    {
        for ( int y = 0; y < cars[x].length; y++) // stepping along the y axis.
        {
            System.out.println(cars[x][y].getYear() + 
                    " " + cars[x][y].getModel() +
                    " " + cars[x][y].getName() +
                    " " + cars[x][y].getManufacturer()); // the super method.
        }
    }

    //INSERTION. 

    // To insert into your array, you simply need to provide the coordinates to insert the new Car(s) object.
    // This next line will insert a new Car into the array at position 1 and the number 2 element of that array.
    cars[1][2] = new Cars( 2014, "someAudi", "My Favorite Car!");

    System.out.println(); // Just adding a space between outputs.

    for ( Cars[] c: cars) //extracting each Cars array and name it c from the 2D Cars array named cars.
    {                     //basically stepping along the x axis and getting each array stored in x.

        for ( Cars car: c) // Now we are stepping along the y axis.
        {                  // We are getting each individual Cars object and naming it car
                           // from each Cars[] named c from our first loop.

            System.out.println(car.getYear() + 
                    " " + car.getModel() +
                    " " + car.getName() +
                    " " + car.getManufacturer()); // the super method.
        }
    }

    // NOTE* if you wish to insert a new element and do not have extra capacity then you will need to
    // create a larger array @ cars[x]. cars[x] = new Cars[newSize];. 

    // DELETION.

    // To delete an element you can just simply overwrite it. 
    // such as:        
    cars[1][1] = new Cars( 2014, "someAudi", "new Audi"); // Essentially we deleted and inserted a new object
                                                          // at position [1][1]. 

    // If you just want to completely remove the element then you will need to update the size of the array.

    // You can define a new array to hold the values of the old array minus the element that should be deleted.
    Cars[] newArray = new Cars[cars[2].length - 1]; // We will use the array stored in cars[2] for this example.
                                                    // we set the length to one less to completely get rid of the
                                                    // old element.    

    int deleteThisPosition = 1; // We will use this variable to store the position that will be deleted from
                                // the array stored in cars[2].

    int newArrayPosition = 0; // We will use this to increment our position in the new array along with `a`
                              // in the next for loop.

    for ( int a = 0; a < cars[2].length; a++)
    {
        if ( a == deleteThisPosition) // if it reaches this position we will advance `a` and exclude it from
             a++;                     // our new array.

        newArray[newArrayPosition] = cars[2][a]; // we will store the value @ position `a` from the array in cars[2]
                                                 // into our newArray @ position `newArrayPosition`.                                     

        newArrayPosition++; // incrementing our variable to stay parallel with the array in cars[2]. 
    }

    //Now we can just assign the newArray to cars[2]. You will notice that Car `2 1` is no longer present.
    cars[2] = newArray;

    System.out.println(); // Just adding a space between outputs.

    for ( Cars[] c: cars) 
    {                                 
        for ( Cars car: c) 
        {                                 
            System.out.println(car.getYear() + 
                    " " + car.getModel() +
                    " " + car.getName() +
                    " " + car.getManufacturer()); // the super method.
        }
    }

  }
}