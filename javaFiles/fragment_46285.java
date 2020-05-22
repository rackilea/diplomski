static class Service {
    List<?> getDTOs(String s) { return null; }
}

@Test
public void example(@Mocked final Service obj) {
    new NonStrictExpectations() {{
        obj.getDTOs("XYZ"); times = 1; // empty list is the default result
        obj.getDTOs(withNotEqual("XYZ")); times = 0;
    }};

    assertEquals(0, obj.getDTOs("XYZ").size());
    obj.getDTOs("abc"); // fails with "unexpected invocation"
}