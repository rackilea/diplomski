// mocking example:
class SomeService {
    private SomeDAO dao; // this is a real dependency, mock it in test
}

// don't mock
Math.max(a,b)

// don't mock
LocalDateTime.of(...)

// don't mock
public int f() {
  ...
  List<Integer> internalVariable = new ArrayList<>(..)
}