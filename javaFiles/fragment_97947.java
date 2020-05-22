public class Counter {
    private CounterDigit[] _digits;

    public Counter(String template) {
        CounterDigit recent = null;
        _digits = new CounterDigit[template.length()];
        for (int i = 0; i < template.length(); ++i) {
            char c = template.charAt(i);
            if      (c == 'A') { recent = new CounterDigit(recent, 'A', 'Z'); }
            else if (c == '0') { recent = new CounterDigit(recent, '0', '9'); }
            else               { recent = new CounterDigit(recent, c, c);     }
            _digits[i] = recent;
        }
    }

    public void increment() {
        _digits[_digits.length-1].increment();
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder(_digits.length);
        for (CounterDigit digit : _digits) {
            b.append(digit.current());
        }
        return b.toString();
    }
}