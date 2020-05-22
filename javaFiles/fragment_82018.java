class MyHelper {

  /** Used for testing. */
  int getPositionFromContextMenuInfo(ContextMenuInfo info) {
    return ((AdapterContextMenuInfo) info).position;
  }
}