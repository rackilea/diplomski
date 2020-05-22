String myString= "a+b-c*d/e";
String[] result = myString.split("(?<=[-+*/])|(?=[-+*/])");
System.out.println(Arrays.toString(result));

/*** Just to see, what the two parts in the above regex print separately ***/
System.out.println(Arrays.toString(myString.split("(?<=[-+*/])")));
System.out.println(Arrays.toString(myString.split("(?=[-+*/])")));