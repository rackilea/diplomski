public class ListState {
  List final a;
  List final b;
  List final c;
}

private volatile ListState _state;

void updateRunOnceEveryFiveMinutes() {
  // generate new lists ...

  // re-assign current list state (e.g. atomically publish all your updates)
  _state = new ListState(newA, newB, newC);
}

public ListState getCurrentLists() {
  return _state;
}