static class DataMapper implements Function<Row, Temp> {

    @Override
    public Temp apply(Row o) {
        String data = o.getString("data");
        String extra = o.getString("extra");
        return new Temp(extra, data);
    }
}