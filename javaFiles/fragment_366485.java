//There are your two test cases
//One is when your code tries to accept an empty string
//One is when you're trying to sum alpha characters.
public void testSumOfString() {
       Assert.Equals(new IllegalArgumentException(),MyObject.sumOfString("")); // MyObject is your class
       // the string that I gave to the method can make the method work because it's empty
    Assert.Equals(new NumberFormatException(), MyObject.sumOfString("Assadsdfcdsvc"); 
    }