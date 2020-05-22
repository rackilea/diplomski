Random rand = new Random();

while(randomized.size() != 0)
{
  int randomNum = rand.nextInt(randomized.size());//produces a number within the range.
  myArrayList.add(randomized.get(randomNum));
  randomized.remove(randomNum);
}
System.out.println("List 1: " + randomized);
System.out.println("List 2: " + myArrayList);