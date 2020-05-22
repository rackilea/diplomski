TournamentTemplateRecord lastActiveTournament = (TournamentTemplateRecord) s.createSQLQuery(
    "SELECT TOP 1 * FROM Tournament_TournamentTemplate tt " +
    "WITH (updlock, rowlock, nowait) " +
    "ORDER BY tt.lastUse desc"
)
    .addEntity(TournamentTemplateRecord.class)
    .uniqueResult();