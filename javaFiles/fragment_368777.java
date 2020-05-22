@TestFactory
DynamicTest generateDynamicTest() {
    return DynamicTest.dynamicTest(
            "2 + 2 = 4", 
            () -> assertEquals(4, 2 + 2, "the world is burning")
    );
}