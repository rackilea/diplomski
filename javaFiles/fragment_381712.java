...

...
int final FACES = 6;
int final THROWS = 10;
int nbTimes[] = new int[FACES];
int Face;

...

for(int thr = 0; thr < THROWS ; thr++){ // int thr = 0 !!! (if you want 10 throws)
    nbTimes[throwDice()] += 1;
}