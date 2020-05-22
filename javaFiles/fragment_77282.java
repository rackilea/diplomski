String nthNumber(String string) {
        Pattern pat = Pattern.compile(
                "(?:\\D+0*(\\d+)\\D+){3,}.*"
        );

        Matcher matcher = pat.matcher(string);
        matcher.matches();
        return matcher.group(1);
    }