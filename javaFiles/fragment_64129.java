@Test
public void testValleyCounting()
{
    Assert.assertEquals(1, countValleys("UDDDUDUU"));
    Assert.assertEquals(2, countValleys("DDUUDDUDUUUD"));
    Assert.assertEquals(2, countValleys("DUDDDUUDUU"));
    Assert.assertEquals(2, countValleys("DUDUUUUUUUUDUDDUUDUUDDDUUDDDDDUUDUUUUDDDUUUUUUUDDUDUDUUUDDDDUUDDDUDDDDUUDDUDDUUUDUUUDUUDUDUDDDDDDDDD"));
}