class compareFirstName implements Comparator<Person>{
@override
public int compareTo(Person p1,Person p2){
return p1.getFirstName().compareTo(p2.getFirstName());
}
}