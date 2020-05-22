Pair<Boolean, String> val = switch (num) {
    case 0 -> Pair.of(true, "zero!");
    case 1 -> Pair.of(true, "one!");
    default -> Pair.of(false, "unknown :/");
};

boolean val1 = val.getLeft();
String val2 = val.getRight();