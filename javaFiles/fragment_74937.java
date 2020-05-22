int randomNumber = rand.nextInt(10);
while (tempSet.contains(randomNumber))
{
    randomNumber = rand.nextInt(10);
    System.out.println("randomNumber= " + randomNumber );
}
tempSet.add(randomNumber); // add this