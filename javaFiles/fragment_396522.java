...
    String name = "";
    String surname = "";
    String address = "";
    String city = "";
    String preferredContact = "";
    String contactID = "";
    String specialism = "";
    String certificationDate = "";
    while(dataScanner.hasNext())
    {
        switch (index) 
        {
            case 0:
                name = dataScanner.next();
                break;

            case 1:
                surname = dataScanner.next();
                break;

            case 2:
                address = dataScanner.next();
                break;

            case 3:
                city = dataScanner.next();
                break;

            case 4:
                preferredContact = dataScanner.next();
                break;

            case 5:
                contactID = dataScanner.next();
                break;

            case 6:
                specialism = dataScanner.next();
                break;

            case 7:
                certificationDate = dataScanner.next();
                break;

            default:
                dataScanner.next();
                break;
        }
        index++;
    }

    if (specialism.equals("surgery")) {
        doctorsList.add(new Surgeon(name, surname, address, city, preferredContact, contactID, specialism, certificationDate));
    } else {
        doctorsList.add(new Doctor(name, surname, address, city, preferredContact, contactID, specialism));
    }