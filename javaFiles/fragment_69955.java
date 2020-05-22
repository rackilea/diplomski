double sf = 1.0D;
if (printMode == JTable.PrintMode.FIT_WIDTH && totalColWidth > imgWidth) {

    // if not, we would have thrown an acception previously
    assert imgWidth > 0;

    // it must be, according to the if-condition, since imgWidth > 0
    assert totalColWidth > 1;

    sf = (double) imgWidth / (double) totalColWidth;
}