public void drawY(int level, double length)
{
    //Drawing the bottom "leg" of our Y shape
    Move Forward length/2
    Save our position 
    Save our direction

    Turn to the right 90 degrees
    Recursion (call drawY())

    revert to original location
    revert to original direction
    move forward length/2 (to go to center point of Y)

    save our new position
    save our new direction 

    //Drawing upper Right Leg
    Turn 60 to the right
    Move Forward length/2 //going to the midpoint
    save our new position (don't forget the center point)
    save our new direction (don't forget the center point direction)
    Turn 90 to the left
    Recursion (call drawY())

    return to our saved position (not center one)
    return to our saved direction (not center one)

    move forward length/2

    //drawing upper left leg
    return to center point
    return to center direction

    turn left 60 
    move forward length/2
    save position (you can overwrite the center one now
    save direction (you can overwrite)

    turn left 90
    Recursion (call drawY())

    return to position
    return to direction
    move forward length/2
}