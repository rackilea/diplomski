String sql = "SELECT p.party_type_id, p.csa_score, p.party_tn, p.rec_create_date" +
                  ", s.strike_id, s.strike_date, s.strike_level, s.strike_status" +
                  ", s.appealable, s.appeal_status, s.rec_change_date, s.event_id" +
                  ", s.is_email_processed, s.policy_id" +
              " FROM strike s" +
             " INNER JOIN parties p ON p.party_id = s.party_id" +
             " WHERE p.account = ?" +
               " AND strike_status = ?";
try (Connection conn = DBConnectionManager.getIntakeConnection();
     PreparedStatement stmt = conn.prepareStatement(sql)) {
    stmt.setString(1, appealStatus.getSubscriberId());
    stmt.setString(2, OCIRISConstants.STRIKE_STATUS_ACTIVE);