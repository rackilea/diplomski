class EmbeddedSwitchChecker implements Checker {
    @Override
    public boolean contains(String s) {
        switch (s.length()) {
        case 3:
            switch (s) {
                case "one":
                case "two":
                case "six":
                    return true;
                default:
                    return false;
            }
        case 4:
            switch (s) {
                case "zero":
                case "four":
                case "five":
                case "nine":
                    return true;
                default:
                    return false;
            }
        case 5:
            switch (s) {
                case "three":
                case "seven":
                case "eight":
                    return true;
                default:
                    return false;
            }
        default:
            return false;
        }
    }
}