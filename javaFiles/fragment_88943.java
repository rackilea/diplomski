@Test
public void foo() {
    RequestUtil requestUtil = new RequestUtil();

    Assert.assertEquals("0BEEC7B5EA3F0FDBC95D0DD47F3C5BC275DA8A33", requestUtil.generateCode("foo".getBytes()));
}