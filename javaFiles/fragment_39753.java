public boolean isAverageGreaterThanMax(double max, int ch) {
    for (int i=0; i<ch; i++)
    {
        if (values[i] <= max) return false ;
    }
    return true ;
}