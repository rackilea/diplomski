public static Apartment getApartment(String aNumber)
{   
    Apartment result = null;
    for (Apartment apartment : listOfApartments) 
    {   
        if (apartment.getApartmentNo().equalsIgnoreCase(aNumber))
        {
             result = apartment;
             break;
        }
    }  
    if (result == null)
    {
        JOptionPane.showMessageDialog(null, "Apartment not found");
    }
    return result;
}