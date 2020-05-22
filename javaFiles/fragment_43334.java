// current combination
StringBuilder builder = new StringBuilder();
for (int i = 0; i < counters.length; i++) {
    String[] combosForCurrentDigit= dialPad[numberAsDigits[i]];
    builder.append(combosForCurrentDigit[counters[i]]);
}
results.add(builder.toString());