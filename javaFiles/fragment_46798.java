public static void main(String [] args)
{
    String test = "test lala idea<I want potatoes<";

    String piecesOfTest[] = test.split("<"); 
    // if you need to split by a dot you need to use "\\."

    System.out.println(piecesOfTest[0]); 
    // prints "test lala idea"
    System.out.println(piecesOfTest[1]); 
    // prints "I want potatoes"

    // Here goes a for loop in case you want to 
    // print the array position by position

}