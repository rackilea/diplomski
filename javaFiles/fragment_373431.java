String str = "The event for mobile is here";
    String temp = "";
    if(str !=null && str.length() > 10) {
        temp = str.substring(0, 10) + "...."; // here 0 is start index and 10 is last index
    } else {
        temp = str;
    }
    System.out.println(temp);