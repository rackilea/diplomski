public class KingdomDAOtest {
    @Tested
    Map<KingdomType, Kingdom> kingdomEmblemMap = new HashMap<>();

    @Tested
    KingdomDAOImpl kingdomDAO;

    @Test
    public void getKingdomsTest() {
        System.out.println("=========+> " + kingdomDAO);
        final Map<KingdomType, Kingdom> actualKingdomEmblemMap = kingdomDAO.getKingdoms();

        Assert.assertEquals(kingdomEmblemMap, actualKingdomEmblemMap);
    }
}