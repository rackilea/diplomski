Group g = new Group();

GroupMember gm1 = new GroupMember();
GroupMember gm2 = new GroupMember();

g.addGroupMember(gm1); // gm1.group is null
g.addGroupMember(gm2);

g.setGroupSpokesman(gm1);

repository.save(g);