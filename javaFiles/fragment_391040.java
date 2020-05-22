String key = String.valueOf(".*?\\b" + "Tom".toLowerCase() + "\\b.*?");
        Pattern p = Pattern.compile(key);
        word = word.toLowerCase().replaceAll("[^a-zA-Z0-9\\s]", "");
        Matcher m = p.matcher(word);
        if (m.find()) {
            countstr++;
        }