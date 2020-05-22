String[] memberList = new String[3];
memberList[0] = "typeA";
memberList[1] = "typeB";
memberList[2] = "typec";

MusicGroup grupo = new MusicGroup();

grupo.setType("888888888889");
grupo.setTitle("hhhhhhh");
grupo.setIntegrantes(memberList);

musicaService.storeGroup(grupo);