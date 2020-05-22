while (randomcounter != randomrequest) {
    result = randomNumbers.nextInt(randomrange);
    array[result] += 1;
    randomcounter +=1;
    for (int i = 0; i < array.length; i++)
    {
        system.out.print(array[i] + " ");
    }
    system.out.println();
}