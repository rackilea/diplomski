class Note {
    private char letter;
    private int octave;
    private boolean sharp;

    private static HashMap<String, Integer> map;

    static {
        map = new HashMap<>();
        map.put("C0", 16);
        map.put("D0", 18);
        map.put("E0", 21);
        map.put("F0", 22);
        map.put("G0", 25);
        map.put("A1", 28);
        // ...
    }

    public Note(char letter, int octave, boolean sharp) {
        this.letter = letter;
        this.octave = octave;
        this.sharp = sharp;
    }

    public char getLetter() {
        return letter;
    }

    public int getOctave() {
        return octave;
    }

    public boolean isSharp() {
        return sharp;
    }

    public double getFrequency() {
        String key = Character.toString(letter) + octave;
        double frequency = map.get(key);
        if (sharp) {
            frequency *= Math.pow(2, 1.0 / 12);
        }
        return frequency;
    }
}