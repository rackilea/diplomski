public class HiLoSequenceGeneratorTest {

    @Test
    public void test() {

        // given
        IdentifierDao dao = mock(IdentifierDao.class);
        when(dao.getUniqueId(anyString())).thenReturn(3, 4, 10, 11);

        HiLoSequenceGenerator gen = new HiLoSequenceGenerator("seq", 3, dao);

        // 3:  9, 10, 11
        // 4: 12, 13, 14
        //10: 30, 31, 32
        //11: 33, 34, 35

        // when - then
        assertEquals(9, gen.getNextId());        // hit db
        assertEquals(10, gen.getNextId());
        assertEquals(11, gen.getNextId());
        assertEquals(12, gen.getNextId());        // hit db
        assertEquals(13, gen.getNextId());
        assertEquals(14, gen.getNextId());
        assertEquals(30, gen.getNextId());        // hit db
        assertEquals(31, gen.getNextId());
        assertEquals(32, gen.getNextId());
        assertEquals(33, gen.getNextId());        // hit db
        assertEquals(34, gen.getNextId());
        assertEquals(35, gen.getNextId());
    }

}