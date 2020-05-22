@Test
public void shouldNotErrorWhenCallingRepairDatabase() throws UnknownHostException {
    // given
    MongoClient mongoClient = new MongoClient();
    DB database = mongoClient.getDB("database");

    // when
    CommandResult result = database.command(new BasicDBObject("repairDatabase", 1));

    // then
    assertThat(result, is(notNullValue()));
    assertThat(result.ok(), is(true));
}