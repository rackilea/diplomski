StringBuilder builder = new StringBuilder();
Formatter f = new Formatter(builder);

for (...) {
    f.format("%s %d\n", entry.getKey(), entry.getValue());
}

return builder.toString();