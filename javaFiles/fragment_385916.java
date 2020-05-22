double width = highBound - lowBound;
double epsilon = .001; // This determines how accurate you want the solution to be, closer to zero = more accurate
double prevValue = -1.0;
double curValue = -1.0; // initialize curValue to a negative value with greater magnitude than epsilon - this ensures that the while loop evaluates to true on the first pass
do {
    ... // this is where your for loop goes
    prevValue = curValue;
    curValue = sumOfArea;
    width /= 2.0;
} while(Math.abs(prevValue - curValue) > epsilon);