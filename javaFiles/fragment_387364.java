public void testGetCrystallographicOrthogonalisation() {

    double[] len = { 10.0, 11.0, 12.0 };
    double[] ang = { 80.0, 90.0, 100.0 }; // degrees!
    RealSquareMatrix m = RealSquareMatrix
        .getCrystallographicOrthogonalisation(len, ang);
    RealSquareMatrix mm = new RealSquareMatrix(3, new double[] {
        9.843316493307713, 0.0, 0.0, -1.7632698070846495,
        10.832885283134289, 0.0, 0.0, 1.9101299543362344, 12.0 });
    MatrixTest.assertEquals("orthogonalise", mm, m, 0.000000000001);
}