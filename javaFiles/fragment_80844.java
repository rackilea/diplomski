public void solution() {
    int y = 0;
    b[0] = -1;
    while (y >= 0) {
        do {
            b[y]++; //if last cell was unsafe or we reached the end of the board, we go for the next row.
        } while ((b[y] < 8) && unsafe(y)); //Checks whether it's the last cell and if it's an unsafe cell (clashing)

        if (b[y] < 8) { //We found a safe cell. Hooray!

            if (y < 7) { //Did we place the last queen?
                b[++y] = -1; //Nope, let's allocate the next one.
            } else {
                putboard(); //Yup, let's print the result!
            }

        } else { //If not a single safe cell was found, we reallocate the last queen.
            y--;
        }
    }
}