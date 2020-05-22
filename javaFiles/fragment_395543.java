pattern = "4578 ";
    String toFind = "7539";

    int samePosition = 0;
    int notSamePosition = 0;

    for (int i = 0; i < toFind.length(); ++i) {
        char digit = toFind.charAt(i);
        if (pattern.contains(String.valueOf(digit))) {
            if (pattern.charAt(i) == digit) {
                ++samePosition;
            } else {
                ++notSamePosition;
            }
        }
    }