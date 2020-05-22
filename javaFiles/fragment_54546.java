@Test
public void myTest()
{
    // Prepare the input parameters:
    PointsCountingTableRow row=...
    float centimetres=...

    // Perform the test:
    int result=countFieldEventPoints(row, centimeters);

    // Check the results:
    String messageInCaseOfFail="row="+row.toString();
    assertEquals(messageInCaseOfFail, expectedResult, result);
}