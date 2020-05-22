StringBuilder buffer = new StringBuilder();
buffer.append("entries: ").append(this.size()).append("\n");
for (Map.Entry entry : entrySet()) {
    buffer.append("key: ").append(entry.getKey().toString()).append(", value:").append(entry.getValue().toString()).append("\n");
}
return buffer.toString();