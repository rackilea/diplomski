class GoodMatchesComparator implements Comparator<Image> {
    @Override
    public int compare(Image i1, Image i2) {
        return Integer.compare(i1.getGoodMatches(), i2.getGoodMatches());
    }
}

class AnotherPropertyComparator implements Comparator<Image> {
    @Override
    public int compare(Image i1, Image i2) {
        return Float.compare(i1.getAnotherProperty(), i2.getAnotherProperty());
    }
}