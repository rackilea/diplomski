//for every "available space" in our "matrix" variable
//we take one "step".
//this "step" is stored in a variable named "i"
for (int i = 0; i < matrix.length; i++)           //<-- outer loop starts here
{
        //initialise an array
        //this irray is as long as the number of loops we've made. (as long as "i" is high)
        //so the first one will be 0 length, the first will be 1 length, etc.
        matrix[i] = new int[i];


        //now, we start on the inner loop. keep in mind that we left "i" the same value.
        //for every available space in the array we just made, we take one "step"
        //this "step" is stored in a variable named "J"

        for(int j = 0; j < matrix[i].length; j++) // <-- inner loop starts here
        {
            //since we don't touch "i", it will be the same for as long as this loop runs.
            matrix[i][j] = i;

            //since we update "j" in every step of this loop, it will be 1 higher every time this loop runs.
            matrix[i][j] = j;
        } // <-- inner loop ends here

 } // <-- outer loop ends here