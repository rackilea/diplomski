User u1 = new User();
    u1.setEmailAddress("email1");
    User u2 = new User();
    u2.setEmailAddress("email2");

    u1List.add(u1);
    u1List.add(u2);
    u2List.add(u2);
    u2List.add(u1);

    userMap.put("1", u1List);
    userMap.put("2", u2List);

    model.addAttribute("userMap", userMap);