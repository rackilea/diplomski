public IndentingStringBuilder append(CharSequence csq, int start, int end) {
    int from = 0;
    while (start < end) {
        if (csq.charAt(start) == '\n') {
            writeLine(csq.toString(), from, start);
            from = start + 1;
            stringBuilder.append(newLine);
            beginningOfLine = true;
            start++;
        } else {
            start++;
        }
    }
    writeLine(csq.toString(), from, start);
    return this;
}