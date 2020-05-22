private static enum CharacterType {

    UPPER {
        @Override
        boolean isA(final char c) {
            return Character.isUpperCase(c);
        }
    },
    LOWER {
        @Override
        boolean isA(final char c) {
            return Character.isLowerCase(c);
        }
    },
    SPACE {
        @Override
        boolean isA(final char c) {
            return Character.isWhitespace(c);
        }
    },
    UNKOWN {
        @Override
        boolean isA(char c) {
            return false;
        }
    };

    abstract boolean isA(final char c);

    public static CharacterType toType(final char c) {
        for (CharacterType type : values()) {
            if (type.isA(c)) {
                return type;
            }
        }
        return UNKOWN;
    }
}

private static String getTransitionType(final CharacterType prev, final CharacterType current) {
    return prev + "_TO_" + current;
}

public static void main(String[] args) {
    final String myString = "AAaaA Aaa  AA";
    final Map<String, Integer> countMap = new TreeMap<String, Integer>() {
        @Override
        public Integer put(final String key, final Integer value) {
            final Integer currentCount = get(key);
            if (currentCount == null) {
                return super.put(key, value);
            }
            return super.put(key, currentCount + value);
        }
    };
    final char[] myStringAsArray = myString.toCharArray();
    CharacterType prev = CharacterType.toType(myStringAsArray[0]);
    for (int i = 1; i < myStringAsArray.length; ++i) {
        final CharacterType current = CharacterType.toType(myStringAsArray[i]);
        countMap.put(getTransitionType(prev, current), 1);
        prev = current;
    }
    for (final Entry<String, Integer> entry : countMap.entrySet()) {
        System.out.println(entry);
    }
}