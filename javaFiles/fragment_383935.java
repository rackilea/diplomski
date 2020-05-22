private Transform chartDisplayTransform(NumberAxis xAxis, NumberAxis yAxis) {
    return new Affine(
            xAxis.getScale(), 0, xAxis.getDisplayPosition(0),
            0, yAxis.getScale(), yAxis.getDisplayPosition(0)
    );
}