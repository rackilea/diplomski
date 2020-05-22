private int foo(Pair<String, ?>... params) {
  if (params[0].snd instanceof String) {
    return 0;
  } else { //if(params[0].snd instanceof List) { //is a List interface, not which List
    // do something else
    return 1;
  }
// return -1; // If it can't happen, why have it here.
}