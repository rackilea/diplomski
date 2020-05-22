try(Connection dbConnection = DBConnectionManager.getIntakeConnection();
PreparedStatement preparedStmtSetMaxStrikeId = dbConnection.prepareStatement(
      "SELECT MAX(strike_id) FROM strike WHERE 'SELECT p.party_type_id,"
//                                             ^ What is this? Even without ' it makes no sense
//                                             ^ But it STARTS A TEXT LITERAL
    + "p.csa_score,p.party_tn,p.rec_create_date,"
    + "s.strike_id, s.strike_date, s.strike_level, s.strike_status, s.appealable,s.appeal_status,s.rec_change_date,s.event_id,s.is_email_processed,s.policy_id"
    + "FROM strike s "
//     ^ Missing space, but it's in a text literal so doesn't matter
    + "INNER JOIN parties p"
    + "ON p.party_id = s.party_id"
//     ^ Missing space, but it's in a text literal so doesn't matter
    + "WHERE p.account ='"+appealStatus.getSubscriberId()
//     ^ Missing space, but it's in a text literal so doesn't matter
//                      ^ END TEXT LITERAL from first line
//                         ^ error complains about inserted value 0957936101205
    +"'AND strike_status = '"+OCIRISConstants.STRIKE_STATUS_ACTIVE+"' ");)
//    ^ Starts a new text literal
//     ^ Missing space, but it's in a text literal so doesn't matter
//                         ^ end text literal
//                            ^ would complain about inserted value ACTIVE
//                                                                  ^ Dangling '