class DateTagLibTests extends TagLibUnitTestCase {

    void testThisYear() {
        String expected = Calendar.getInstance().get(Calendar.YEAR)
        tagLib.thisYear()
        assertEquals("years do NOT match", expected, tagLib.out)
    }

}