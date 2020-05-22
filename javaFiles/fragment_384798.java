List<String> decoded = new ArrayList<String>(10);
for (int i = 0; i < 10; i++) {
    decoded.add(""); // Or perhaps null
}

...
decoded.set(1, "S"): // This is now fine, replacing element 1