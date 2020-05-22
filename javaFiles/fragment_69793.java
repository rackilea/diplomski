public String replace(String str) {
        StringBuilder sb = new StringBuilder();
        char[] strArray = str.toCharArray();
        int i = 0;
        while (i < strArray.length - 1) {
            if (strArray[i] == '$' && strArray[i + 1] == '{') {
                i = i + 2;
                int begin = i;
                while (strArray[i] != '}') ++i;
                sb.append(map.get(str.substring(begin, i++)));
            } else {
                sb.append(strArray[i]);
                ++i;
            }
        }
        if (i < strArray.length) sb.append(strArray[i]);
        return sb.toString();
    }