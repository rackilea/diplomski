// Put this into your constant gravity function
// Or whatever you have that makes the player fall
// This should be altering a local gravity modifier in the player
if(jumpKeyHeld) {
    locaGravAccel = 0.5
} else {
    locaGravAccel = 1.0
}