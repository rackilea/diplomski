public class square extends shape {
//square member variables
boolean equalSides = true;
int numSides = 4;
//and so on

//OR even better, don't define them, since the base class already does!
//merely set the values in the constructor
public square(){
       numSides = 4;
       equalSides = true;
       shapeHint = "Geeks were called this in the 80s";
    }
}