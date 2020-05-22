private void writeLine(String str, int from, int to) {
    if (beginningOfLine && to > 0) {
        writeIndent();
        beginningOfLine = false;
    }
    stringBuilder.append(str, from, to);
}