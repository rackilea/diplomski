for(int rowIndex = 0; rowIndex < initialVelocity.length; rowIndex++)
{
    System.out.print(initialVelocity[rowIndex] + " ");                
    for(int colIndex = 0; colIndex < radians.length; colIndex++)
    {
        answers[rowIndex][colIndex] = ((Math.pow(initialVelocity[rowIndex], 2) * Math.sin(radians[colIndex]))/ 9.8);
        System.out.printf("%9.1f ", answers[rowIndex][colIndex]);
    }
    System.out.println();
}