int sizeEstimate = failures.size() * 20;
StringBuilder builder = new StringBuilder(sizeEstimate);
builder.append("Failed operations\n");
builder.append("=================\n\n");
while (!failures.isEmpty()) {
    builder.append(failures.remove(0));      
    builder.append('\n');      
}