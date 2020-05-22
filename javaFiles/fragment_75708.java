public enum LettersAndNumbers {
    A(1, 2), B(2, 3);
    private int numberone;
    private int numbertwo;
    private static Map<Integer, Integer> numbers = new HashMap<>();
    static {
        for (LettersAndNumbers lan : LettersAndNumbers.values()) {
            numbers.put(lan.numberone, lan.numbertwo);
        }
    }

    private LettersAndNumbers(int numberone, int numbertwo) {
        this.numberone = numberone;
        this.numbertwo = numbertwo;
    }

    public static Integer getNumberTwo(int numberone) {
        return numbers.get(numberone);
    }
}