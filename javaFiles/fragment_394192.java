int personNumber = 0;
for(String people: myPeople)
{
System.out.println(String.format("Person %d is named %s, and their name is %d characters long", personNumber + 1, people, people.length());
personNumber++;
}