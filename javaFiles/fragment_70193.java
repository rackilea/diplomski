String hours = "0";
    String minutes = strTDiff.substring(0, 1);

    if (length == 4)
    {
        hours = strTDiff.substring(0, 2);
        minutes = strTDiff.substring(3, 5);
    }
    else if (length == 3)
    {
        hours = strTDiff.substring(0);
        minutes = strTDiff.substring(2, 4);
    }
System.out.println(hours + " hours " + minutes + " minutes");