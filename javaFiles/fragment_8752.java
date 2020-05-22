// create a Map to hold `mail_id` and their corresponding `id` values 
Map<Long, Long> mailIdMap = new TreeMap<Long, Long>();
for (MailidInvitation a : invitationList) {
    // mail_id, id (id is null for now)
    mailIdMap.put(a.getId(), null);
}

// try INSERTing all `mail_id` values
try (PreparedStatement ps = dbConn.prepareStatement(
        "INSERT INTO mail_contacts (mail_id) VALUES (?)", 
        PreparedStatement.RETURN_GENERATED_KEYS)) {
    for (Long mid : mailIdMap.keySet()) {
        ps.setLong(1, mid);
        ps.addBatch();
    }
    int[] updateCounts = null;
    try {
        updateCounts = ps.executeBatch();
    } catch (BatchUpdateException bue) {
        updateCounts = bue.getUpdateCounts();
    }
    // get generated keys and insert them into the Map
    try (ResultSet rs = ps.getGeneratedKeys()) {
        int i = 0;
        for (Long mid : mailIdMap.keySet()) {
            if (updateCounts[i++] == 1) {
                rs.next();
                mailIdMap.put(mid, rs.getLong(1));
            }
        }
    }
}

// <demo>
System.out.println("mailIdMap now contains:");
// </demo>

// build a SELECT statement to get the `id` values for `mail_id`s that already existed
//     ... and print the existing mailIdMap values for demo purposes
StringBuilder sb = new StringBuilder(
        "SELECT id, mail_id " +
        "FROM mail_contacts " +
        "WHERE mail_id IN (");
int n = 0;
for (Map.Entry<Long, Long> entry : mailIdMap.entrySet()) {
    String idValue = "";  // <demo />
    if (entry.getValue() == null) {
        if (n++ > 0) sb.append(',');
        sb.append(entry.getKey());
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
sb.append(')');
String sql = sb.toString();

// <demo>
System.out.println();
System.out.println(sql);
// </demo>