@Override
public List<PlayerDetails> testPlayerQuerry() {
    return copyPlayersToDetails(em.createNativeQuery("select p.* from player p\n"
            + "join Player_Game pg on p.player_id = pg.fk_player_id\n"
            + "join Game g on pg.fk_game_id = g.game_id\n"
            + "where g.game_id = 2", Player.class).getResultList());
}