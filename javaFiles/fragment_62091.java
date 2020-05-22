public void saveOfficer(Officers officer) {
        logger.info("In saveOfficer");

        int count = getJdbcTemplate().update("INSERT INTO crimetrack.tblofficers (userName,password, fName, lName, oName, divisionNo, positionId, emailAdd, startDate, endDate, genderId,phoneNo, dob,badgeNo) "+
                                                "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)"
                                                , new Object[]{officer.getUserName(),StringSecurity.EncryptString(officer.getPassword()),officer.getfName(),
                                                 officer.getlName(),officer.getoName(),officer.getDivisionNo(),officer.getPositionId(),
                                                 officer.getEmailAdd(),officer.getStartDate(),officer.getEndDate(),officer.getGenderId(),
                                                 officer.getPhoneNo(),officer.getDob(),officer.getBadgeNo()});

        logger.info(count +" Rows affected in tblOfficers");            

    }