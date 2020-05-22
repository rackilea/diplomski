List<Integer> values = new ArrayList<Integer>();

values.add(val1);
values.add(val2);
// And so forth...

boolean pass = true;

for (Integer v : values) {
    if (v != 0) {
        pass = false;
        // You could log which variable failed here...
    }
}

if (pass) {
    // Do something
} else {
    // Do something else
}