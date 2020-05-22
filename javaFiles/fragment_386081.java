int[] hotels = {0, 0, 0, 0}; // Declare array with 4 empty values

// Add person to hotel #1
++hotels[0]; // Array indexes start at 0

// Use loop to access every index of array and perform a task each time
for(int i = 0; i < hotels.length; i++){
    System.out.println("Hotel #" + i + " has " + hotels[i] + " guests.");
}