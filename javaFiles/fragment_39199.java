Member oldMember = new Member("foo" ,"chan" ,"AB12" , 21 ,LocalDateTime.now());
Member newMember = new Member("bar" ,"chan" ,"AB12" , 22 ,LocalDateTime.now());

Diff diff = javers.compare(oldMember, newMember);
for(Change change:  diff.getChanges()) {
    System.out.println(change);
}