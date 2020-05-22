@Test
public void whenDatacenterIsNotCORPThenLocalPookStringShouldIncludeEnumName() {
    new MockUp<TestUtils>() {
        @Mock String getEnvironmentName() { return "production"; }
    };

    DatacenterEnum notCORP = DatacenterEnum.LVS;
    String ss = Deencapsulation.invoke(notCORP, "toLocalPookString");

    assertTrue(ss.toUpperCase().endsWith(notCORP.name()));
}