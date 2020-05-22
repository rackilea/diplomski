public void moveDot(NavigationFilter.FilterBypass fb, int dot, Position.Bias bias) {
    if (dot >= iMaxLenght) {
        fb.moveDot(iMaxLenght, bias);
    } else {
        fb.moveDot(dot, bias);
    }
}