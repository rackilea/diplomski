string firstName = head.getFirstName();
string lastName = head.getLastName();
string phoneNum = head.getPhoneNum();
string email = head.getEmail();

if ((firstName != null && firstName.contains(searchEntry)) 
     || (lastName != null && lastName.contains(searchEntry)) 
     || (phoneNum != null && phoneNum.contains(searchEntry)) 
     || (email != null && email.contains(searchEntry)))