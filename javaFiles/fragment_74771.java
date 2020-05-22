@Override
public List<PlayerDetails> testPlayerQuerry() {
    return copyPlayersToDetails(em.createNativeQuery("select p.* from player p\n"
          + "join Player_Game pg on p.player_id = pg.fk_player_id\n"
          + "where pg.fk_game_id = :1", Player.class).setParameter(1, 2).getResultList());
}