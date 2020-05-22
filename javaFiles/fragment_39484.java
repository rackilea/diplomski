String str = "+1-646-222-3333";
    if(str.matches("\\+\\d-\\d{3}-\\d{3}-\\d{4}")) {
        System.out.println("Valid number");
    }else {
        System.out.println("Invalid number");
    }