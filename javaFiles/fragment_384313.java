public static void main(String[] args) {
    String input = "ATC";
    char packed = 0;
    for (char c : input.toCharArray()) {
        Base base = Base.valueOf(String.valueOf(c));
        packed = base.getPacked(packed);
    }
}