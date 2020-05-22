class Even implements Function<Integer,Boolean> {
    Even(){}

    @Override
    public Boolean apply(Integer integer) {
        return (integer % 2) == 0;
    }
}