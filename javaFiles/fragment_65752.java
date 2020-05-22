public static Float[][] toFloatArray2(String s) {
    return Pattern.compile("[\\[\\]]+[,]?")
            .splitAsStream(s)
            .filter(x -> !x.trim().isEmpty())
            .map(row -> Pattern.compile("\\D+")
                        .splitAsStream(row)
                        .map(r -> Float.valueOf(r.trim()))
                        .toArray(Float[]::new)
            )
            .toArray(Float[][]::new);
}