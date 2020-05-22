Group g = new Group();

GroupMember gm1 = new GroupMember(); // gm1.group is set to ID of g
GroupMember gm2 = new GroupMember();

g.addGroupMember(gm1);
g.addGroupMember(gm2);

repository.save(g);

g.setGroupSpokesman(gm1);

repository.save(g);