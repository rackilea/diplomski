public void testGetActionMapping() {
    ActionMapping mapping = getActionMapping("/cInfo.action");
    assertNotNull(mapping);
    assertEquals("/", mapping.getNamespace());
    assertEquals("cInfo", mapping.getName());
}

public void testGetActionProxy() throws Exception {        
    ActionProxy proxy = getActionProxy("/cInfo.action");
    assertNotNull(proxy);

    CustInfo action = (CustInfo) proxy.getAction();
    assertNotNull(action);

    String result = proxy.execute();
    assertEquals(Action.SUCCESS, result);
}