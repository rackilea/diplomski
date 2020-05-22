private int[] chooseProblem(float bias, int[] currentShuffle) { 
// if bias == 0, we choose from uniform distribution
// for 0 < bias <= 1, we choose from increasingly biased distribution
// for bias > 1, we choose from uniform distribution
// array currentShuffle contains the numbers 0..90, initially in shuffled order
// when a problem is solved correctly it is moved to the top of the pile
// when it is wrong, it is moved to the bottom.
// return value contains number1, number2, and the current position of the problem in the list
    int problem, problemIndex;

    if(bias < 0 || bias > 1) bias = 0;

    if(bias == 0) {
        problem = random.nextInt(91);
        problemIndex = problem;
    }
    else {
        float x = asin(Math.random()*bias)/asin(bias);
        problemIndex = Math.floor(91*x);
        problem = currentShuffle[problemIndex];
    }

    // now convert "problem number" into two numbers:
    int first, last;    
    first = (int)((Math.sqrt(8*problem + 1)-1)/2);
    last = problem - first * (first+1) / 2;

    // and return the result:
    return {first, last, problemIndex};
}


private void shuffleProblems(int[] currentShuffle, int upDown) {
// when upDown==0, return a randomly shuffled array
// when upDown < 0, (wrong answer) move element[-upDown] to zero
// when upDown > 0, (correct answer) move element[upDown] to last position
// note - if problem 0 is answered incorrectly, don't call this routine!

    int ii, temp, swap;

    if(upDown == 0) {

        // first an ordered list:
        for(ii=0;ii<91;ii++) {
            currentShuffle[ii]=ii;
        }

        // now shuffle it:
        for(ii=0;ii<91;ii++) {
            temp = currentShuffle[ii];
            swap = ii + random.nextInt(91-ii);
            currentShuffle[ii]=currentShuffle[swap];
            currentShuffle[swap]=temp;
        }
        return;
    }

    if(upDown < 0) {
        temp = currentShuffle[-upDown];
        for(ii = -upDown; ii>0; ii--) {
            currentShuffle[ii]=currentShuffle[ii-1];
        }
        currentShuffle[0] = temp;
    }
    else {
        temp = currentShuffle[upDown];
        for(ii = upDown; ii<90; ii++) { 
            currentShuffle[ii]=currentShuffle[ii+1];
        }
        currentShuffle[90] = temp;
    }
    return;
}


// main problem posing loop:

int[] currentShuffle = new int[91];
int[] newProblem;
int keepGoing = 1;

// initial shuffle:
shuffleProblems( currentShuffle, 0); // initial shuffle

while(keepGoing) {
    newProblem = chooseProblem(bias, currentShuffle);
    // pose the problem, get the answer
    if(wrong) {
        if(newProblem > 0) shuffleProblems( currentShuffle, -newProblem[2]);
    }
    else shuffleProblems( currentShuffle, newProblem[2]);
    // decide if you keep going...
}