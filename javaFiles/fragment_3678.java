@Category(UnitTest.class)
@RunWith(MockitoJUnitRunner.class)
public class ZoneTrimTransformerTest {



@Test
public void testLengths()
{
    ZoneTrimTransformer lztr = new ZoneTrimTransformer(5);

    assertEquals(lztr.transform("İİİİİİİİİİ"),"İİ");
    assertEquals(lztr.getDBRequireLength(lztr.transform("İİİİİİİİİİ").toString()),4);
    assertEquals(lztr.getJavaLength(lztr.transform("İİİİİİİİİİ").toString()),2);

    assertEquals(lztr.transform("%&*%$^&$$^&$").toString(),"%&*%$");
    assertEquals(lztr.getDBRequireLength(("%&*%$^&$$^&$").toString()),12);
    assertEquals(lztr.getJavaLength(("%&*%$^&$$^&$").toString()),12);

    assertEquals(lztr.transform("媒体アカウント名"),"媒");
    assertEquals(lztr.getDBRequireLength(("媒体アカウント名").toString()),24);
    assertEquals(lztr.getJavaLength(("媒体アカウント名").toString()),8);

    assertEquals(lztr.transform("媒体媒体アカウント名アカウント名"),"媒");
    assertEquals(lztr.getDBRequireLength(("媒体媒体アカウント名アカウント名").toString()),48);
    assertEquals(lztr.getJavaLength(("媒体媒体アカウント名アカウント名").toString()),16);

    assertEquals(lztr.transform("SÄ°STA+UNÄ°VERSAL"),"SÄ°");
    assertEquals(lztr.getDBRequireLength(("SÄ°STA+UNÄ°VERSAL").toString()),21);
    assertEquals(lztr.getJavaLength(("SÄ°STA+UNÄ°VERSAL").toString()),17);

    assertEquals(lztr.transform("1234567890"),"12345");
    assertEquals(lztr.getDBRequireLength(("1234567890").toString()),10);
    assertEquals(lztr.getJavaLength(("1234567890").toString()),10);

    assertEquals(lztr.transform("abcdefghI"),"abcde");
    assertEquals(lztr.getDBRequireLength(("abcdefghI").toString()),9);
    assertEquals(lztr.getJavaLength(("abcdefghI").toString()),9);

    assertEquals(lztr.transform("אהגדהוזחט"),"אה");
    assertEquals(lztr.getDBRequireLength(("אהגדהוזחט").toString()),18);
    assertEquals(lztr.getJavaLength(("אהגדהוזחט").toString()),9);

    assertEquals(lztr.transform("ABAA"),"ABAA");
    assertEquals(lztr.getDBRequireLength(("ABAA").toString()),4);
    assertEquals(lztr.getJavaLength(("ABAA").toString()),4);


    assertEquals(lztr.getDBRequireLength(lztr.transform("ABCE").toString()),4);
    assertEquals(lztr.getJavaLength(lztr.transform("ABCE").toString()),4);



}