if (map.get(key).matches("(?i)t(rue)?|y(es)?")) {
  // true boolean
} else if (map.get(key).matches("(?i)f(alse)?|n(o)?")) {
  // false boolean
} else {
  // not boolean
}