public String testMatch(String data, String... regExs) {
    for(String regEx : regExs) {
        if(data.matches(regEx)) {
            return regEx;
        }
    }

    return null;
}