int[] results = new int[100];

// fill map with results
for(int index = 0; index < randomNumbers.length; index++)
{
    // if number on randomnumbers is 2, this line sum +1 in position 2 of the array
    results[randomNumbers[index]] = results[randomNumbers[index]] + 1;
}