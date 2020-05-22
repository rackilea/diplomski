// This is a loop with AN EMPTY STATEMENT FOR A BODY due to the
// immediately trailing semicolon.
// Even when this loop is corrected per above, the condition will never
// change state due to lack of increment and it will "loop forever".
for(e > 2; e < (phiPQ - 1);) ;

// This is a new block, that does NOT BELONG to the loop above.
{
    int larger = phiPQ;
    int smaller = e;
    int r = 1;
    r = larger / smaller;
    larger = smaller;
    smaller = r;
}