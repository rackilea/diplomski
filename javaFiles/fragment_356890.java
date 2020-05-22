string[] strArray = new[] {"aa", "bb"};

object[] objArray = strArray;    //covariance: so far, so good
//objArray really is an "alias" for strArray (or a pointer, if you wish)


//i can haz cat?
object cat == new Cat();         //a real cat would object to being... objectified.

//now assign it
objArray[1] = cat                //crash, boom, bang
                                 //throws ArrayTypeMismatchException