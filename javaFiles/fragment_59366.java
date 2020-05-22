private static class RangeEvaluator extends MinMaxDateEvaluator {

    @Override
    public boolean isInvalid(Date date) {
        return !super.isInvalid(date);
    }
}