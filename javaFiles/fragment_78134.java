// should only be done once, in some initialization block
Random myRand = new Random();     

// Then, once you have your Random instance:
if (myRand.nextBoolean()) {
    addition();
} else {
    subtraction();
}