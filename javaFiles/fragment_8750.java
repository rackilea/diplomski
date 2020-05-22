try (Connection dbConn = DriverManager.getConnection(myConnectionString, "root", "usbw")) {
    dbConn.setAutoCommit(false);

    // test data and setup
    Long aid = 123L;
    List<MailidInvitation> invitationList = new ArrayList<MailidInvitation>();
    invitationList.add(new MailidInvitation(13L));
    invitationList.add(new MailidInvitation(11L));
    invitationList.add(new MailidInvitation(12L));
    // remove stuff from previous test run
    try (Statement s = dbConn.createStatement()) {
        s.executeUpdate("DELETE FROM mail_contacts WHERE mail_id IN (11,13)");
    }
    try (PreparedStatement ps = dbConn.prepareStatement(
            "DELETE FROM inv_table WHERE aid=?")) {
        ps.setLong(1, aid);
        ps.executeUpdate();
    }

    // real code starts here
    //
    // create a Map to hold `mail_id` and their corresponding `id` values 
    Map<Long, Long> mailIdMap = new TreeMap<Long, Long>();
    for (MailidInvitation a : invitationList) {
        // mail_id, id (id is null for now)
        mailIdMap.put(a.getId(), null);
    }

    // build an SQL statement to retrieve any existing values
    StringBuilder sb = new StringBuilder(
            "SELECT id, mail_id " +
            "FROM mail_contacts " +
            "WHERE mail_id IN (");
    int n = 0;
    for (Map.Entry<Long, Long> entry : mailIdMap.entrySet()) {
        if (n++ > 0) sb.append(',');
        sb.append(entry.getKey());
    }
    sb.append(')');
    String sql = sb.toString();

    // run the query and save the results (if any) to the Map
    try (Statement s = dbConn.createStatement()) {
        // <demo>
        System.out.println(sql);
        // </demo>
        try (ResultSet rs = s.executeQuery(sql)) {
            while (rs.next()) {
                mailIdMap.put(rs.getLong("mail_id"), rs.getLong("id"));
            }
        }
    }

    // <demo>
    System.out.println();
    System.out.println("mailIdMap now contains:");
    // </demo>

    // build a list of the `mail_id` values to INSERT (where id == null)
    //     ... and print the existing mailIdMap values for demo purposes
    List<Long> mailIdsToInsert = new ArrayList<Long>();
    for (Map.Entry<Long, Long> entry : mailIdMap.entrySet()) {
        String idValue = "";  // <demo />
        if (entry.getValue() == null) {
            mailIdsToInsert.add(entry.getKey());
            // <demo>
            idValue = "null";  
        } else {
            idValue = entry.getValue().toString();
            // </demo>
        }
        // <demo>
        System.out.println(String.format(
                "    %d - %s", 
                entry.getKey(),
                idValue));
        // </demo>
    }

    // batch insert `mail_id` values that don't already exist
    try (PreparedStatement ps = dbConn.prepareStatement(
            "INSERT INTO mail_contacts (mail_id) VALUES (?)", 
            PreparedStatement.RETURN_GENERATED_KEYS)) {
        for (Long mid : mailIdsToInsert) {
            ps.setLong(1, mid);
            ps.addBatch();
        }
        ps.executeBatch();
        // get generated keys and insert them into the Map
        try (ResultSet rs = ps.getGeneratedKeys()) {
            n = 0;
            while (rs.next()) {
                mailIdMap.put(mailIdsToInsert.get(n++), rs.getLong(1));
            }
        }
    }

    // <demo>
    System.out.println();
    System.out.println("After INSERT INTO mail_contacts, mailIdMap now contains:");
    for (Map.Entry<Long, Long> entry : mailIdMap.entrySet()) {
        System.out.println(String.format(
                "    %d - %s", 
                entry.getKey(),
                entry.getValue()));
    }
    // </demo>

    // now insert the `inv_table` rows
    try (PreparedStatement ps = dbConn.prepareStatement(
            "INSERT INTO inv_table (mid, aid) VALUES (?,?)")) {
        ps.setLong(2, aid);
        for (MailidInvitation a : invitationList) {
            ps.setLong(1, mailIdMap.get(a.getId()));
            ps.addBatch();
        }
        ps.executeBatch();
    }
    dbConn.commit();
}