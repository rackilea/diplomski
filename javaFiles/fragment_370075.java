public Date parse(String str) {
    try {
        return new SimpleDateFormat("yyyyMMdd").parse(str);
    } catch (ParseException e) {
        throw new RuntimeException(e);
    }
}