while (true) {
  Integer old = accumulator.get(key);
  if (old == null) {
    if (accumulator.putIfAbsent(key, 0) == null) {
      // note: it's a little surprising that you want to put 0 in this case,
      // are you sure you don't mean 1?
      break;
    }
  } else if (accumulator.replace(key, old, old + 1)) {
    break;
  }
}