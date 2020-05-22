public int compare(Viewer viewer, Object e1, Object e2) {

Person p1 = (Person) e1;
Person p2 = (Person) e2;
int rc = 0;

if(!p1.getFirstName().equals(p2.getFirstName())) {
    rc = p1.getFirstName().compareTo(p2.getFirstName());
}else if(!p1.getLastName().equals(p2.getLastName())) {
    rc = p1.getLastName().compareTo(p2.getLastName());
}else if(!p1.getGender().equals(p2.getGender())) {
    rc = p1.getGender().compareTo(p2.getGender());
}else if(!p1.isMArried==p2.isMarried) {
    rc = (p1.isMarried() ? 1 : -1);
}else rc=0;

return rc;
}