java.util.Random random = new Random();

boolean[] r_occupied;
boolean[] c_occupied;

for (i = 0; i < vowels.length; i++)
  {
    // Clear the 'occupied' information
    r_occupied = new boolean[5];
    c_occupied = new boolean[5];

    // we will put vowel[i] 'count' times into the 'board'
    count = random.nextInt(5);

    for (j = 0; j < count; j++)
      {
        // generate a random row
        row = random.nextInt(5);

        // if it is already occupied, select the next one
        while (r_occupied[row])
          row = (row + 1) % 5;

        // generate a random column
        col = random.nextInt(5);

        // if it is already occupied, select the next one
        while (c_occupied[col])
          col = (col + 1) % 5;

        /* put the vowel at board[row][col] */
        r_occupied[row] = true;
        c_occupied[col] = true;
        board[row][col] = vowel[i];
      }
  }