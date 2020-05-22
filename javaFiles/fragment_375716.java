static class DataMapper {

    public static Temp apply(Row o) {
        String data = o.getString("data");
        String extra = o.getString("extra");
        return new Temp(extra, data);
    }
}