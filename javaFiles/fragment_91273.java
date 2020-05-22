if (inputString.charAt(0) == 'I') {
        major = "Information Management";
    } else if(inputString.charAt(0) == 'C') {
        major = "Computer Science";
    } else if(inputString.charAt(0) == 'A') {
        major  = "Accounting";
    } else {
        System.out.println("Invalid input");
    }

    if (inputString.charAt(1) == '1') {
        title = "Freshman";
    } else if(inputString.charAt(1) == '2') {
        title = "Sophomore";
    } else if(inputString.charAt(1) == '3') {
        title  = "Junior";
    } else if(inputString.charAt(1) == '4') {
        title  = "Senior";
    } else {
        System.out.println("Invalid input");
    }

    if (!major.equals("") && !title.equals("")) {
        System.out.println(major + " " + title);
    }