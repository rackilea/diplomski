private final String s;

public CaseInsensitiveString(String s) {
    //for real code probably use locale version
    this.s = s.toLowerCase();
}