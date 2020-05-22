Public int compareTo(Person per) {
    if(firstName.compareTo(per.firstName) != 0){
        return firstName.compareTo(per.firstName);
    }
    else{
        return lastName.compareTo(per.lastName);
    }

}