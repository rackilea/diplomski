if (line.contains("A") && !line.contains("B")) {
    updatedLines.add(line + "|" + "this is A");
}

if (line.contains("B") && !line.contains("A")) {
    updatedLines.add(line + "|" + "this is B");
}

if (line.contains("A") && line.contains("B")) {
    updatedLines.add(line + "|" + "this is A with B");
}