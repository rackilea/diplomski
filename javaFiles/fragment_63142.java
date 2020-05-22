Realm realmObj;

    //declaration
    realmObj= Realm.getDefaultInstance();

realmObj.executeTransaction(realm -> {
    meeting = realm.where(Meeting.class).equalTo("id", meetingId).findFirst();

    department = realm.where(Department.class).equalTo("id", departmentId).findFirst();

    //add members
    for (Member member : department.getMembers()) {
        if (!thereIsInList(member,meeting.getMembers()))
            meeting.getMembers().add(member);
    }

  });