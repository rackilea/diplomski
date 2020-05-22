// checks, how long will be the next stack line and returns it (values from 0 to 5)
public int check() {
        // if this is the first line for the player
        if (start == true) {
                // return the size of the current stack
                // (in this case it is 5, because initialization of array length is {5, 5})
                return length[1];
        // if the horizontal index of the last stack is smaller than the horizontal index of the current stack
        } else if (last < deltax[1]) {
                // if the horizontal index of the current stack plus the current stack size is less or equal than the horizontal index of the last stack plus the last stack size
                if (deltax[1] + length[1] <= last + length[0]) {  // i removed the double -1, it's unnecessary
                        // return the size of the current stack
                        return length[1];
                } else {
                        // else return the congruent size of the current and the last stack
                        return length[1] - Math.abs((deltax[1] + length[1]) - (last + length[0]));
                }
        // if the horizontal index of the last stack is greater than the horizontal index of the current stack
        } else if (last > deltax[1]) {
                // return the congruent size of the current stack minus the difference between the current and the last horizontal index of the stack
                return length[1] - Math.abs(deltax[1] - last);
        // else the last stack will be directly under the currect stack
        } else {
                // so just return the size of the current stack
                return length[1];
        }
}