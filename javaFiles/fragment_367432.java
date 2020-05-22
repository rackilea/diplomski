boolean first = true;
StringBuilder sb = new StringBuilder();
for (String s : expList) {
    sp.append("(?:").append(Pattern.quote(s)).append(')');
    if (!first) {
        sb.append('|');
    }
    first = false;
}

Pattern pattern = Pattern.compile(sb.toString());

// Possibly make this a ForkJoinTask
int count = 0;
for (String s : textToBeTested) {
    if (pattern.matcher(s).matches()) {
        count++;
    }
}