while (inputFile.hasNext() && index < numbers.length) {

    numbers[index] = inputFile.nextInt();
    index++;

}

index = 0; // add this

while (!found && index < SIZE) {

    if (numbers[index] == (number))
        found = true;
    else
        index++;
}
return found;