String onlyNumbers = "^[0-9.]*$";
        String onlyAlphabets = "[a-zA-Z]*$";
        final Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            final Map.Entry<String, String> entry = iterator.next();
            if (!entry.getValue().matches(onlyNumbers)&&!entry.getValue().matches(onlyAlphabets)) {
                iterator.remove();
            }
        }