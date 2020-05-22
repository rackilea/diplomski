@Test
public void test() {
    int f = 100;

    double d = 123.456;
    double temp = d * f;
    double rounded = Math.round(temp);
    double to2dp = rounded / f;

    Assert.assertEquals(123.46, to2dp, 0.00001);
}