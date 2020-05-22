if (first.length() > second.length()) {
    longer = first;
    shorter = second;
} else {
    longer = second;
    shorter = first;
}

last = shorter.length() - 1;

for(int i = 0; i < longer.length(); i++) {
    s = shorter.get(Math.min(last, i));
    l = longer.get(i);
    if (abs(l-s) > threshold) {
        break;
    }
}