final int LIMIT = 5; // <-- try to avoid magic numbers.
boolean myBoolean = (value < LIMIT); // <-- assigns the result of the expression 
                                    //    `value < LIMIT` to `myBoolean`.
while(myBoolean) {
    System.out.println(value);
    value = value + 1; // <-- value++;
    myBoolean = (value < LIMIT);
}