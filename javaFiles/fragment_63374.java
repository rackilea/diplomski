List<Member> busyMember= Arrays.asList(getBusyMember());
List<Team> allMembers= new ArrayList<Team>(jsonParsed.getAllElement());
List<Member> availableMembers = new ArrayList<Member>();
for(Team t : allMembers){
    availableMembers.add(t.getMember());
}
availableMembers.removeAll(busyMember);