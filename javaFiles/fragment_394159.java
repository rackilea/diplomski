StringBuilder stringBuilder = new StringBuilder();

for (Entry<String, TreeSet<String>> mapEntry : treemap.entrySet()) {
    stringBuilder.append(mapEntry.getKey());
    if (mapEntry.getValue() != null) {
        for (String setEntry : mapEntry.getValue()) {
            stringBuilder.append(" ").append(setEntry);
        }
    }
    stringBuilder.append("\n");
}

System.out.println(stringBuilder.toString());