Float[] firstElement = new Float[2];
firstElement[0] = 1.0f;   // x value 
firstElement[1] = 42.0f;  // y value

Object[] coordinates = new Object[1];
coordinates[0] = firstElement;

com.android.Coordinates coordObject = new com.android.Coordinates();
coordObject.Updates(coordinates);