String baseEntityAlias = null;
    Pattern pattern = Pattern.compile("SELECT.+?FROM.+?\\w+?\\s+?(\\w+)", Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher(jpqlString);
    if (matcher.find()) {
        baseEntityAlias = matcher.group(1);
    }
    Assert.hasText(baseEntityAlias, "Not able to find the base Entity Alias for the JPQL Query=" + jpqlString);
    return baseEntityAlias;
}