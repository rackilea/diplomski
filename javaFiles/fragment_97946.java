public class CounterDigit {
    private final CounterDigit _higher;
    private final String _chars;
    private int _index = 0;

    public CounterDigit(CounterDigit higher, String chars) {
        _higher = higher;
        _chars = chars;
    }

    public CounterDigit(CounterDigit higher, char first, char last) {
        this(higher, charRange(first, last));
    }

    private static String charRange(char first, char last) {
        StringBuilder b = new StringBuilder();
        for (char c = first; c <= last; ++c) {
            b.append(c);
        }
        return b.toString();
    }

    public char current() {
        return _chars.charAt(_index);
    }

    public void increment() {
        if (++_index >= _chars.length()) {
            _index = 0;
            if (_higher != null) {
                _higher.increment();
            }
        }
    }
}