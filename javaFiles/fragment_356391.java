String sql = "select reim.reimb_id, reim.reimb_amount,"
           + "reim.reimb_submitted, reim.reimb_resolved, "
           + "CONCAT(CONCAT(u.user_first_name,' '),"
           + " u.user_last_name) AS \"REIMB_AUTHOR\", "
           + "reim.REIMB_RESCRIPTION, rst.REIMB_STATUS, "
           + "rtype.REIMB_TYPE, CONCAT(CONCAT(urs.user_first_name,'   '), "
           + "urs.user_last_name) AS \"REIMB_RESOLVER\" " // Here
           + "FROM ERS_REIMBURSTMENT reim " // and here
           + "LEFT JOIN ERS_USERS u " // and here
           + "ON u.ERS_USERS_ID = reim.REIMB_AUTHOR " // and here
           + "LEFT JOIN ERS_REIMBURSTMENT_STATUS rst " // and here
           + "ON rst.REIMB_STATUS_ID = reim.REIMB_STATUS_ID " // and here
           + "LEFT JOIN ERS_REIMBURSTMENT_TYPE rtype " // and here
           + "ON rtype.reimb_type_id = reim.REIMB_TYPE_ID " // and here
           + "LEFT JOIN ERS_USERS urs " // and here
           + "ON urs.ERS_USERS_ID = reim.REIMB_RESOLVER " // and here
           + "ORDER BY reim.reimb_id";