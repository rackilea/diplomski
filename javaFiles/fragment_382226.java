try {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    result = sdf.parse(data2).compareTo(sdf.parse(data1));
    if (result != 0) {
        return result;
    }
} catch (final ParseException e) {
    /* continue */
}