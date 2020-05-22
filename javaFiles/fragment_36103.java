TranscriptStatusCounts tsc = new TranscriptStatusCounts();
    //'NEW','EXPORT_READY','PENDING_MATCH','MATCHED_ID','PROCESSED','REJECTED'
    tsc.setNewCount(rs.getLong(1));
    tsc.setExportReadyCount(rs.getLong(2));
    tsc.setPendingMatchCount(rs.getLong(3));
    tsc.setMatchedIdCount(rs.getLong(4));
    tsc.setProcessedCount(rs.getLong(5));
    tsc.setRejectedCount(rs.getLong(6));
    return tsc;