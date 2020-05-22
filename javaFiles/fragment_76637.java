interface F1
    String apply(String);
    F1 and(F1);

interface F2
    String apply(String,String);
    F1 curry(String);