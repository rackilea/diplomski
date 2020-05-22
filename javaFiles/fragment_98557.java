int i;
for (i = 0; i + max < ids.size(); i += max) {
  chunks.add(ids.subList(i, i + max));
}
if (i < ids.size()) {
  chunks.add(ids.subList(i, ids.size());
}