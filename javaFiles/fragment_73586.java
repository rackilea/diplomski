public int getNationalMinutes() {
  if (national) {
    return callDuration;
  }
  return 0;
}

public int getInternationalMinutes() {
  if (!national) {
    return callDuration;
  }
  return 0;
}