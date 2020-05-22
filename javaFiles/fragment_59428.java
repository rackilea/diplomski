public static History getPerson(String p){
    switch(p){
        case "a":
            return new Person1();
        default:
            return new Person2();
    }
 }