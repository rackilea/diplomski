// Create an array of Rooms
Room rooms[] = new Room[8];
// Now, you have a placeholder for 8 rooms
// Know that it are simply placeholders, the rooms are not initialized.
// Each element of the array is initialized to null

// Assigning
rooms[2] = new Room(3, 2); // Initialize the room at index 2 (which is the 3th 
                           // in spoken language)


// Retrieving
int index = 4; // Indices start at 0
Room room4 = rooms[index];

// Or...
rooms[5].doSomething();


// Getting the length
int numberOfRooms = rooms.length;