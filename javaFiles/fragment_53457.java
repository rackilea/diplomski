int getLowerBound(Pair<enum, Integer> condition) {
  switch (condition.first) {
  case EQUALS:
  case GE:
    return condition.second;
  case GT:
    return condition.second + 1;
  case LT: case LE:
    return Integer.MIN_VALUE;
  }
}

int getUpperBound(Pair<enum, Integer> condition) {
  switch (condition.first) {
  case EQUALS:
  case GE: case GT:
    return Integer.MAX_VALUE;
  case LT:
    return condition.second - 1;
  case LE:
    return condition.second;
  }
}