public void testCountry() {

    Rhino rA = new Rhino("USA", null);
    Rhino rB = new Rhino("USA", rA);
    Rhino rC = new Rhino("CANADA", rB);
    Rhino rD = new Rhino("USA", rC);

    int expectedResult = 3;
    assertEquals(expectedResult, rD.numCountry("USA"));
}