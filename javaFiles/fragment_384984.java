String value = "FirstNameLastName yy-mm-ddAddress                       FirstNameLastName yy-mm-ddAddress                       FirstNameLastName yy-mm-ddAddress                       ";

    for (int i = 0; i < value.length(); i++)
    {
        System.out.println("First Name : "+value.substring(i, i + 9));
        System.out.println("Last Name : "+value.substring((i + 9), i + 18));
        System.out.println("Date : "+value.substring(i + 18, i + 26));
        System.out.println("Address : "+value.substring(i + 26, i + 56));
        i = i + 55;
    }