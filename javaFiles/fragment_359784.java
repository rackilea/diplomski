public static String findNeedle(Object[] haystack) {
        for(int i = 0 ; i < haystack.length ; i ++) {
            if("needle".equals(haystack[i])) {
                return String.format("found the needle at position %s", i);
            }
        }
        return null;
    }