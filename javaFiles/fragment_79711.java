public boolean equals(Name otherName){
    if(firstName.equalsIgnoreCase(otherName.firstName) && middleName.equalsIgnoreCase(otherName.middleName) && lastName.equalsIgnoreCase(otherName.lastName))
        return true;
    else 
        return false;
}