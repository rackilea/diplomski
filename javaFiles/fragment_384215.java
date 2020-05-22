class SwitchChecker implements Checker {
    @Override
    public boolean contains(String s) {
        switch (s) {
            case "zero":
            case "one":
            case "two":
            case "three":
            case "four":
            case "five":
            case "six":
            case "seven":
            case "eight":
            case "nine":
                return true;
            default:
                return false;
        }
    }
}