System.out.print("Please enter firstname: ");
firstName=scan.next();
System.out.print("Please enter lastname: ");
lastName=scan.next();
key = lastName.concat(firstName);
System.out.println("name:" + key);
ad1.removeContact(key);  
scan.nextLine(); // This is will make sure that in you next loop `nextInt()` won't give an input mismatch exception