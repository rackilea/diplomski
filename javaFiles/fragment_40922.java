//Let's say you got a list of User object List<User> ls
Iterator<User> it= ls.iterator();
int i=1;
while(it.hasnext()){
 User u= (User) it.next();
 System.out.println("("+i+") : ID= "+u.getId()+" Firstname= "+u.getFirstName()+" Secondname= "+ u.getSecondName);
 i++;
}
System.out.println("Please enter the index of the wanted result:");
Scanner scan = new Scanner(System.in);
int index=scan.nextInt()-1; //index in list count from 0
if(index<=ls.size()){
  System.out.println("the expected result is:");
  System.out.println("ID= "+ls.get(index).getId()+" Firstname= "+ls.get(index).getFirstName()+" Secondname= "+ ls.get(index).getSecondName);
}