PreparedStatement pstmt = conn.prepareStatement(
            "INSERT INTO clinical_study ("
            + "PRIMARY_OUTCOME_MEASURE, "
            + "PRIMARY_OUTCOME_TIME_FRAME, "
            + "PRIMARY_OUTCOME_SAFETY_ISSUE, "
            + "PRIMARY_OUTCOME_DESCRIPTION, "
            + "SECONDARY_OUTCOME_MEASURE, "
            + "SECONDARY_OUTCOME_TIME_FRAME, "
            + "SECONDARY_OUTCOME_SAFETY_ISSUE, "
            + "SECONDARY_OUTCOME_DESCRIPTION) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
    pstmt.setString(1, clinicalStudy.getPrimaryOutcome().getMeasure());
    pstmt.setString(2, clinicalStudy.getPrimaryOutcome().getTimeFrame());
    pstmt.setString(3, clinicalStudy.getPrimaryOutcome().getSafetyIssue());
    pstmt.setString(4, clinicalStudy.getPrimaryOutcome().getDescription());
    pstmt.setString(5, clinicalStudy.getSecondaryOutcome().getMeasure());
    pstmt.setString(6, clinicalStudy.getSecondaryOutcome().getTimeFrame());
    pstmt.setString(7, clinicalStudy.getSecondaryOutcome().getSafetyIssue());
    pstmt.setString(8, clinicalStudy.getSecondaryOutcome().getDescription());
    pstmt.execute();