for (int j = 0; j < arr.length; j++) // <== possibly arr.length is what you need.
{
    String temp = arr[j]; // <=== was i, same next line
    numIngredients[j] = Integer.parseInt(temp);
    System.out.println(
         "This is numIngredients index: " + j + //<== j this line
         " and value " + numIngredients[j]); // <== again, was using [i] 

}